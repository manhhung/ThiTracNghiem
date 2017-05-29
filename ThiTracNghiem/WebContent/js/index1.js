$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function confirmXoa(){
    return confirm("Bạn có muốn xóa tài khoản này không?");
}
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

$(function() {
	$('.DatePicker').datepicker({
		showOn: "button",
		buttonImage: "anh/calendar7.png",
		buttonImageOnly: false,
		constrainInput: false
	});

	$("img[class='ui-datepicker-trigger']").each(function () {
		$(this).attr('style', 'background-position: right; background-repeat: no-repeat; position:relative; top: 6px; left: -20px;');
	});


});
function isNumberKey(evt){
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode != null) {
		return false;
	}
	return true;
}
 