$(document).ready(function() {
    $('#showPostForm').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide();
        $('#postForm').show();
    });

    $('#showGetForm').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide();
        $('#getForm').show();
        $('#getRequestButton').click(); // Trigger the getRequestButton click event
    });

    $('#showPutForm').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide();
        $('#putForm').show();
    });

    $('#createCampaignButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide();
        $('#postForm').show();
    });

    $('#updateCampaignButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('.form-container').hide();
        $('#putForm').show();
    });

    $('#returnToGetFormButton').on('click', function () {
        $('#response').html('');
        $('#showGetForm').click(); // Return to Show GET Form
    });

    $('#returnToGetFormButtonPut').on('click', function () {
        $('#response').html('');
        $('#showGetForm').click(); // Return to Show GET Form
    });

    $('#apiForm').on('submit', function (event) {
        event.preventDefault();

        const fromDate = new Date($('#from').val());
        const toDate = new Date($('#to').val());

        const offsetFromDate = fromDate.toISOString();
        const offsetToDate = toDate.toISOString();

        const inputData = JSON.stringify({
            name: $('#name').val(),
            description: $('#description').val(),
            from: offsetFromDate,
            to: offsetToDate,
            pictureURL: $('#pictureURL').val(),
            detailsUri: $('#detailsUri').val(),
            pictureName: $('#pictureName').val()
        });

        const processData = JSON.parse(inputData);

        console.log("Input Data:", processData);
        $.ajax({
            url: '/api/v1/campaigns',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(processData),
            dataType: 'json',
            success: function (data) {
                console.log('AJAX request successful:', data);
                $('#response').html(formatResponseAsTable(data));
                // $('#getRequestButton').click();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('AJAX request failed:', textStatus, errorThrown);
                $('#response').text('Error: ' + errorThrown);
            }
        });
    });

    $('#getRequestButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('#campaignList').show();

        $.ajax({
            url: '/api/v1/campaigns',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log('GET request successful:', data);
                $('#campaignList').html(formatCampaignsWithCheckboxes(data));
                $('#deleteSelectedCampaignsButton').show();
                $('#deleteSelectedCampaignButton').hide();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('GET request failed:', textStatus, errorThrown);
                $('#response').text('Error: ' + errorThrown);
            }
        });
    });

    $('#getByIdButton').on('click', function () {
        $('#response').html(''); // Clear the response
        $('#deleteSelectedCampaignsButton').hide();
        const campaignId = $('#campaignId').val();
        if (!campaignId) {
            alert('Please enter a campaign ID');
            return;
        }

        $('#campaignList').hide();

        $.ajax({
            url: `/api/v1/campaigns/${campaignId}`,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log('GET by ID request successful:', data);
                $('#response').html(`<h2>Campaign ${campaignId}</h2>` + formatCampaignsWithCheckboxes([data]));
                $('#deleteSelectedCampaignButton').show();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('GET by ID request failed:', textStatus, errorThrown);
                $('#response').text('Error: Campaign ID Not Found ' + errorThrown);
            }
        });
    });

    $('#putApiForm').on('submit', function (event) {
        event.preventDefault();

        const campaignId = $('#putCampaignId').val();

        const fromDate = new Date($('#putFrom').val());
        const toDate = new Date($('#putTo').val());

        const offsetFromDate = fromDate.toISOString();
        const offsetToDate = toDate.toISOString();

        const inputData = JSON.stringify({
            name: $('#putName').val(),
            description: $('#putDescription').val(),
            from: offsetFromDate,
            to: offsetToDate,
            pictureURL: $('#putPictureURL').val(),
            detailsUri: $('#putDetailsUri').val(),
            pictureName: $('#putPictureName').val()
        });

        const processData = JSON.parse(inputData);

        console.log("Input Data:", processData);
        $.ajax({
            url: `/api/v1/campaigns/${campaignId}`,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(processData),
            dataType: 'json',
            success: function (data) {
                console.log('PUT request successful:', data);
                $('#response').html(formatResponseAsTable(data));
                // $('#showGetForm').click(); // Return to Show GET Form
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('PUT request failed:', textStatus, errorThrown);
                $('#response').text('Error: ' + errorThrown);
            }
        });
    });

    $('#deleteSelectedCampaignsButton').on('click', function () {
        $('#response').html(''); // Clear the response
        const selectedCampaignIds = [];
        $('input[name="campaignCheckbox"]:checked').each(function () {
            selectedCampaignIds.push($(this).val());
        });

        if (selectedCampaignIds.length === 0) {
            alert('Please select at least one campaign to delete.');
            return;
        }

        selectedCampaignIds.forEach(function (campaignId) {
            $.ajax({
                url: `/api/v1/campaigns/${campaignId}`,
                type: 'DELETE',
                success: function () {
                    console.log(`Campaign ${campaignId} deleted successfully`);
                    $(`#campaignRow${campaignId}`).remove();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.error(`DELETE request for campaign ${campaignId} failed:`, textStatus, errorThrown);
                    let errorMessage = 'Error: ' + errorThrown;
                    if (jqXHR.status === 404) {
                        errorMessage = 'Error: Campaign not found';
                    }
                    $('#response').text(errorMessage);
                }
            });
        });
    });

    $('#deleteSelectedCampaignButton').on('click', function () {
        const selectedCampaignId = $('input[name="campaignCheckbox"]:checked').val();
        if (!selectedCampaignId) {
            alert('Please select at least one campaign to delete.');
            return;
        }

        $.ajax({
            url: `/api/v1/campaigns/${selectedCampaignId}`,
            type: 'DELETE',
            success: function () {
                console.log(`Campaign ${selectedCampaignId} deleted successfully`);
                $('#response').html(`Campaign ${selectedCampaignId} deleted successfully`);
                $('#deleteSelectedCampaignButton').hide(); // Hide the delete button
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error(`DELETE request for campaign ${selectedCampaignId} failed:`, textStatus, errorThrown);
                let errorMessage = 'Error: ' + errorThrown;
                if (jqXHR.status === 404) {
                    errorMessage = 'Error: Campaign not found';
                }
                $('#response').text(errorMessage);
            }
        });
    });

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
        console.table(table);
        return table;
    }



    function formatResponseAsTable(data) {
        if (!Array.isArray(data)) {
            data = [data];
        }

        let table = '<table><tr>';
        for (let key in data[0]) {
            table += `<th>${key}</th>`;
        }
        table += '</tr>';

        data.forEach(item => {
            table += '<tr>';
            for (let key in item) {
                table += `<td>${item[key]}</td>`;
            }
            table += '</tr>';
        });

        table += '</table>';
        return table;
    }
});