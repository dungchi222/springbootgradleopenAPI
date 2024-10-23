$(document).ready(function() {
    $('#showPostForm').on('click', function() {
        $('.form-container').hide();
        $('#postForm').show();
    });

    $('#showGetForm').on('click', function() {
        $('.form-container').hide();
        $('#getForm').show();
        $('#getRequestButton').click(); // Trigger the getRequestButton click event
    });

    $('#showPutForm').on('click', function() {
        $('.form-container').hide();
        $('#putForm').show();
    });

    $('#createCampaignButton').on('click', function() {
        $('.form-container').hide();
        $('#postForm').show();
    });

    $('#updateCampaignButton').on('click', function() {
        $('.form-container').hide();
        $('#putForm').show();
    });

    $('#returnToGetFormButton').on('click', function() {
        $('#showGetForm').click(); // Return to Show GET Form
    });

    $('#returnToGetFormButtonPut').on('click', function() {
        $('#showGetForm').click(); // Return to Show GET Form
    });

    $('#apiForm').on('submit', function(event) {
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
            success: function(data) {
                console.log('AJAX request successful:', data);
                $('#response').html(formatResponseAsTable(data));
                $('#showGetForm').click(); // Return to Show GET Form
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('AJAX request failed:', textStatus, errorThrown);
                $('#response').text('Error: ' + errorThrown);
            }
        });
    });

    $('#getRequestButton').on('click', function() {
        $.ajax({
            url: '/api/v1/campaigns',
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log('GET request successful:', data);
                $('#response').html('<h2>List of campaigns</h2>' + formatResponseAsTable(data));
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('GET request failed:', textStatus, errorThrown);
                $('#response').text('Error: ' + errorThrown);
            }
        });
    });

    $('#getByIdButton').on('click', function() {
        const campaignId = $('#campaignId').val();
        if (!campaignId) {
            alert('Please enter a campaign ID');
            return;
        }

        $.ajax({
            url: `/api/v1/campaigns/${campaignId}`,
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                console.log('GET by ID request successful:', data);
                $('#response').html(`<h2>Campaign ${campaignId}</h2>` + formatResponseAsTable([data]));
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('GET by ID request failed:', textStatus, errorThrown);
                $('#response').text('Error: ' + errorThrown);
            }
        });
    });

    $('#putApiForm').on('submit', function(event) {
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
            success: function(data) {
                console.log('PUT request successful:', data);
                $('#response').html(formatResponseAsTable(data));
                $('#showGetForm').click(); // Return to Show GET Form
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('PUT request failed:', textStatus, errorThrown);
                $('#response').text('Error: ' + errorThrown);
            }
        });
    });

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