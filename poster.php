<?php

$host = 'localhost';
$username = 'id12324975_root';
$pwd = 'internety';
$db = "id12324975_soccerdb";

$con = mysqli_connect($host, $username, $pwd, $db) or die('Unable to connect');

if (mysqli_connect_error($con)) {
    echo "Failed to Connect to Database " . mysqli_connect_error();
}

$name = $_POST['Name'];


$sql = "INSERT INTO soccerDB(jump) VALUES('$name')";

$result = mysqli_query($con, $sql);

if ($result) {
    echo ('Successfully Saved');
} else {
    echo ('Not saved Successfully');
}
mysqli_close($con);
