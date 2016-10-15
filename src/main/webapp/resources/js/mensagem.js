mensagem = {
    verificaMensagem: function () {
        var me = this;
        $.ajax({
            method: 'POST',
            url: '/web/anunciante/mensagem/verifica',
            success: function (data) {
                $('#menuConversa').text('+' + data.length);
                setTimeout(function () {
                    me.verificaMensagem();
                }, 15000);
            },
            failure: function (data) {
                setTimeout(function () {
                    me.verificaMensagem();
                }, 15000);
            }
        });
    }
};