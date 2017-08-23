function loadPayment() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("formload").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "edccoordinator/payment.html", true);
  xhttp.send();
}

function loadStudent() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("formload").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "edccoordinator/studentForm.html", true);
  xhttp.send();
}