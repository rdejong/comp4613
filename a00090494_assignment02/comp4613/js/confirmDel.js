function myFunction()
{
var x;
var r=confirm("Do you really want to delete this customer?");
if (r==true)
  {
  x="Customer Delete Confirmed";
  }
else
  {
  x="Customer Delete Cancelled";
  }
document.getElementById("cancelled").innerHTML=x;
}

