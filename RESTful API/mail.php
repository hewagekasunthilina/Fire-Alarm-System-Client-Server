<?php
// the message
$msg = "Hi, Please Note That the Co2 or Smoke level has Increased. This May Cause an Emergency Situation!".print_r($_POST);

// use wordwrap() if lines are longer than 70 characters
$msg = wordwrap($msg,70);

// send email
mail("kasunthilina1000@gmail.com","Fire Alert!",$msg);
echo "send".print_r($_POST);
?>