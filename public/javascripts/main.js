function check(results) {
    $('span').remove();
    for (let key in results) {
        let element = document.getElementById(key);
        let span = document.createElement('span');
        span.innerHTML = results[key];
        // inputの上にエラーの生成
        element.parentNode.appendChild(span, element);
    }
}

function parseJson(data) {
    var returnJson = {};
    for (idx = 0; idx < data.length; idx++) {
        returnJson[data[idx].name] = data[idx].value
    }
    return JSON.stringify(returnJson);
}

$(function() {
    $('button').on('click',function(){
        var data = parseJson($('form').serializeArray());
        $.post({
            url: $('form').attr('action'),
            data: data,
            contentType: 'application/json',
        }).then(
            results => $('span').remove(),
            error => check(error.responseJSON)
        );
    });
});
