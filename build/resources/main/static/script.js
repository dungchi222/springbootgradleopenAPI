// debugger;
$(document).ready(function() {
    console.log("script.js is loaded and running");

    $('#apiForm').on('submit', function(event) {
        event.preventDefault();

        // const inputData = $('#inputData').val();
        const inputData = JSON.parse($('#inputData').val());
        // const inputData = {
        //     name: "Campaign 2024",
        //     description: "This is a campaign for 2024",
        //     from: "2000-01-23T04:56:07.000+00:00",
        //     to: "2024-12-31T23:59:59Z",
        //     pictureURL  : "https://example/2024",
        //     detailsUri: "https://example.com/campaigns/2024",
        //     pictureName: "pic2024.jpg"
        // };


        console.log("Input Data:" + inputData);
        debugger;
        $.ajax({
            // url: 'http://localhost:8080/api/v1/campaigns',
            url: '/api/v1/campaigns',
            type: 'POST',
            contentType: 'application/json',
            // data: JSON.stringify({ data: inputData }),
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
});