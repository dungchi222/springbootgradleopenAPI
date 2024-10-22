$(document).ready(function() {
    console.log("script.js is loaded and running");

    $('#showPostForm').on('click', function() {
        $('#postForm').show();
        $('#getForm').hide();
        $('#putForm').hide();
        $('#response').text(''); // Clear the response
    });

    $('#showGetForm').on('click', function() {
        $('#postForm').hide();
        $('#getForm').show();
        $('#putForm').hide();
        $('#response').text(''); // Clear the response
    });

    $('#showPutForm').on('click', function() {
        $('#postForm').hide();
        $('#getForm').hide();
        $('#putForm').show();
        $('#response').text(''); // Clear the response
    });

    $('#apiForm').on('submit', function(event) {
        event.preventDefault();

        const inputData = JSON.parse($('#inputData').val());

        console.log("Input Data:", inputData);
        $.ajax({
            url: '/api/v1/campaigns',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(inputData),
            dataType: 'json',
            success: function(data) {
                console.log('AJAX request successful:', data);
                $('#response').text(JSON.stringify(data, null, 2));
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
                $('#response').html(formatResponseAsTable(data));
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
                $('#response').html(formatResponseAsTable([data]));
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('GET by ID request failed:', textStatus, errorThrown);
                $('#response').text('Error: ' + errorThrown);
            }
        });
    });

    $('#putApiForm').on('submit', function(event) { // New PUT request handler
        event.preventDefault();

        const campaignId = $('#putCampaignId').val();
        const inputData = JSON.parse($('#putInputData').val());

        console.log("Input Data:", inputData);
        $.ajax({
            url: `/api/v1/campaigns/${campaignId}`,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(inputData),
            dataType: 'json',
            success: function(data) {
                console.log('PUT request successful:', data);
                $('#response').text(JSON.stringify(data, null, 2));
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