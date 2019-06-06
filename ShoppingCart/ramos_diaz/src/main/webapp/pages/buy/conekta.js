Conekta.setPublicKey('key_FqD7qn3VvVoy6fUnuFA32CQ');
Conekta.setLanguage("en");

var conektaSuccessResponseHandler = function(token) {
  var $form = $("#card-form");
  //Inserta el token_id en la forma para que se envíe al servidor
  $form.append($('<input type="hidden" name="conektaTokenId" id="conektaTokenId">').val(token.id));
  $form.get(0).submit(); //Hace submit
};

var conektaErrorResponseHandler = function(response) {
  var $form = $("#card-form");
  var $footer = $("#credit-card-footer");
  $form.find(".card-errors").text(response.message_to_purchaser);
  //$("#btnPay").prop("disabled", false);
  $footer.append($('<a class = "btn btn-info" href = "javascript:location.reload()">Try again!</a>'));
};

//jQuery para que genere el token después de dar click en submit
$(function () {
  $("#card-form").submit(function(event) {
    var $form = $(this);
    // Previene hacer submit más de una vez
    $("#btnPay").prop("disabled", true);
    Conekta.Token.create($form, conektaSuccessResponseHandler, conektaErrorResponseHandler);
    return false;
  });
});