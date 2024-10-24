$(document).ready(function() {
    // Show the POST form and hide other forms
    $('#showPostForm').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide(); // Hide all form containers
        $('#postForm').show(); // Show the POST form
    });

    // Show the GET form and hide other forms
    $('#showGetForm').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide(); // Hide all form containers
        $('#getForm').show(); // Show the GET form
        $('#getRequestButton').click(); // Trigger the getRequestButton click event to load campaigns
    });

    // Show the PUT form and hide other forms
    $('#showPutForm').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide(); // Hide all form containers
        $('#putForm').show(); // Show the PUT form
    });

    // Show the POST form for creating a new campaign
    $('#createCampaignButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide(); // Hide all form containers
        $('#postForm').show(); // Show the POST form
    });

    // Show the PUT form for updating an existing campaign
    $('#updateCampaignButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide(); // Hide all form containers
        $('#putForm').show(); // Show the PUT form
    });

    // Return to the GET form from the POST form
    $('#returnToGetFormButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('#showGetForm').click(); // Trigger the showGetForm click event to return to the GET form
    });

    // Return to the GET form from the PUT form
    $('#returnToGetFormButtonPut').on('click', function () {
        $('#response').html(''); // Clear the response
        $('#showGetForm').click(); // Trigger the showGetForm click event to return to the GET form
    });

    // Handle the submission of the POST form
    $('#apiForm').on('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        // Convert the 'from' and 'to' dates to ISO strings
        const fromDate = new Date($('#from').val());
        const toDate = new Date($('#to').val());
        const offsetFromDate = fromDate.toISOString();
        const offsetToDate = toDate.toISOString();

        // Create the input data object
        const inputData = JSON.stringify({
            name: $('#name').val(),
            description: $('#description').val(),
            from: offsetFromDate,
            to: offsetToDate,
            pictureURL: $('#pictureURL').val(),
            detailsUri: $('#detailsUri').val(),
            pictureName: $('#pictureName').val()
        });

        const processData = JSON.parse(inputData); // Parse the input data to ensure it's a valid JSON object

        console.log("Input Data:", processData); // Log the input data for debugging
        $.ajax({
            url: '/api/v1/campaigns', // API endpoint for creating a new campaign
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(processData), // Send the input data as JSON
            dataType: 'json',
            success: function (data) {
                console.log('AJAX request successful:', data); // Log the success response
                $('#response').html(formatResponseAsTable(data)); // Display the response in a table format
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('AJAX request failed:', textStatus, errorThrown); // Log the error response
                $('#response').text('Error: ' + errorThrown); // Display the error message
            }
        });
    });

    // Handle the GET request to fetch all campaigns
    $('#getRequestButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('#campaignList').show(); // Show the campaign list

        $.ajax({
            url: '/api/v1/campaigns', // API endpoint for fetching all campaigns
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log('GET request successful:', data); // Log the success response
                $('#campaignList').html(formatCampaignsWithCheckboxes(data)); // Display the campaigns with checkboxes
                $('#deleteSelectedCampaignsButton').show(); // Show the delete selected campaigns button
                $('#deleteSelectedCampaignButton').hide(); // Hide the delete selected campaign button
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('GET request failed:', textStatus, errorThrown); // Log the error response
                $('#response').text('Error: ' + errorThrown); // Display the error message
            }
        });
    });

    // Handle the GET request to fetch a campaign by ID
    $('#getByIdButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('#deleteSelectedCampaignsButton').hide(); // Hide the delete selected campaigns button
        const campaignId = $('#campaignId').val(); // Get the campaign ID from the input field
        if (!campaignId) {
            alert('Please enter a campaign ID'); // Alert if the campaign ID is not provided
            return;
        }

        $('#campaignList').hide(); // Hide the campaign list

        $.ajax({
            url: `/api/v1/campaigns/${campaignId}`, // API endpoint for fetching a campaign by ID
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log('GET by ID request successful:', data); // Log the success response
                $('#response').html(`<h2>Campaign ${campaignId}</h2>` + formatCampaignsWithCheckboxes([data])); // Display the campaign details
                $('#deleteSelectedCampaignButton').show(); // Show the delete selected campaign button
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('GET by ID request failed:', textStatus, errorThrown); // Log the error response
                $('#response').text('Error: Campaign ID Not Found ' + errorThrown); // Display the error message
            }
        });
    });

    // Handle the submission of the PUT form
    $('#putApiForm').on('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        const campaignId = $('#putCampaignId').val(); // Get the campaign ID from the input field

        // Convert the 'from' and 'to' dates to ISO strings
        const fromDate = new Date($('#putFrom').val());
        const toDate = new Date($('#putTo').val());
        const offsetFromDate = fromDate.toISOString();
        const offsetToDate = toDate.toISOString();

        // Create the input data object
        const inputData = JSON.stringify({
            name: $('#putName').val(),
            description: $('#putDescription').val(),
            from: offsetFromDate,
            to: offsetToDate,
            pictureURL: $('#putPictureURL').val(),
            detailsUri: $('#putDetailsUri').val(),
            pictureName: $('#putPictureName').val()
        });

        const processData = JSON.parse(inputData); // Parse the input data to ensure it's a valid JSON object

        console.log("Input Data:", processData); // Log the input data for debugging
        $.ajax({
            url: `/api/v1/campaigns/${campaignId}`, // API endpoint for updating a campaign
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(processData), // Send the input data as JSON
            dataType: 'json',
            success: function (data) {
                console.log('PUT request successful:', data); // Log the success response
                $('#response').html(formatResponseAsTable(data)); // Display the response in a table format
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('PUT request failed:', textStatus, errorThrown); // Log the error response
                $('#response').text('Error: ' + errorThrown); // Display the error message
            }
        });
    });

    // Handle the deletion of selected campaigns
    $('#deleteSelectedCampaignsButton').on('click', function () {
        $('#response').html(''); // Clear the response
        const selectedCampaignIds = [];
        $('input[name="campaignCheckbox"]:checked').each(function () {
            selectedCampaignIds.push($(this).val()); // Collect the IDs of selected campaigns
        });

        if (selectedCampaignIds.length === 0) {
            alert('Please select at least one campaign to delete.'); // Alert if no campaigns are selected
            return;
        }

        selectedCampaignIds.forEach(function (campaignId) {
            $.ajax({
                url: `/api/v1/campaigns/${campaignId}`, // API endpoint for deleting a campaign
                type: 'DELETE',
                success: function () {
                    console.log(`Campaign ${campaignId} deleted successfully`); // Log the success response
                    $(`#campaignRow${campaignId}`).remove(); // Remove the deleted campaign row from the table
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.error(`DELETE request for campaign ${campaignId} failed:`, textStatus, errorThrown); // Log the error response
                    let errorMessage = 'Error: ' + errorThrown;
                    if (jqXHR.status === 404) {
                        errorMessage = 'Error: Campaign not found'; // Display a specific error message if the campaign is not found
                    }
                    $('#response').text(errorMessage); // Display the error message
                }
            });
        });
    });

    // Handle the deletion of a selected campaign
    $('#deleteSelectedCampaignButton').on('click', function () {
        const selectedCampaignId = $('input[name="campaignCheckbox"]:checked').val(); // Get the ID of the selected campaign
        if (!selectedCampaignId) {
            alert('Please select at least one campaign to delete.'); // Alert if no campaign is selected
            return;
        }

        $.ajax({
            url: `/api/v1/campaigns/${selectedCampaignId}`, // API endpoint for deleting a campaign
            type: 'DELETE',
            success: function () {
                console.log(`Campaign ${selectedCampaignId} deleted successfully`); // Log the success response
                $('#response').html(`Campaign ${selectedCampaignId} deleted successfully`); // Display the success message
                $('#deleteSelectedCampaignButton').hide(); // Hide the delete button
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error(`DELETE request for campaign ${selectedCampaignId} failed:`, textStatus, errorThrown); // Log the error response
                let errorMessage = 'Error: ' + errorThrown;
                if (jqXHR.status === 404) {
                    errorMessage = 'Error: Campaign not found'; // Display a specific error message if the campaign is not found
                }
                $('#response').text(errorMessage); // Display the error message
            }
        });
    });

    // Format the campaigns data with checkboxes for selection
    function formatCampaignsWithCheckboxes(data) {
        let table = '<table><tr><th>Select</th><th>ID</th><th>Name</th><th>Description</th><th>From</th><th>To</th><th>Picture URL</th><th>Details URI</th><th>Picture Name</th></tr>';
        data.forEach(item => {
            // console.log(item);
            table += `<tr id="campaignRow${item.id}">`;
            table += `<td><input type="checkbox" name="campaignCheckbox" value="${item.id}"></td>`;
            table += `<td>${item.id}</td>`;
            table += `<td>${item.name}</td>`;
            table += `<td>${item.description}</td>`;
            table += `<td>${item.From}</td>`;
            table += `<td>${item.to}</td>`;
            table += `<td>${item.pictureURL}</td>`;
            table += `<td>${item.detailsUri}</td>`;
            table += `<td>${item.pictureName}</td>`;
            table += '</tr>';
        });
        table += '</table>';
        console.table(table); // Log the table for debugging
        return table;
    }

    // Format the response data as a table
    function formatResponseAsTable(data) {
        if (!Array.isArray(data)) {
            data = [data]; // Ensure the data is an array
        }

        let table = '<table><tr>';
        for (let key in data[0]) {
            table += `<th>${key}</th>`; // Add table headers
        }
        table += '</tr>';

        data.forEach(item => {
            table += '<tr>';
            for (let key in item) {
                table += `<td>${item[key]}</td>`; // Add table data
            }
            table += '</tr>';
        });

        table += '</table>';
        return table;
    }
});