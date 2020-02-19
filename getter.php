<?php

$host = 'localhost';
$username = 'id12324975_root';
$pwd = 'internety';
$db = "id12324975_soccerdb";

$con = mysqli_connect($host, $username, $pwd, $db) or die('Unable to connect');

if (mysqli_connect_error($con)) {
    echo "Failed to Connect to Database " . mysqli_connect_error();
}

$sql = "SELECT * FROM soccerDB";
$result = $con->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while ($row = $result->fetch_assoc()) {
        echo $row["jump"];
    }
} else {
}

$sql = 'DELETE FROM soccerDB';

if ($con->query($sql) === TRUE) {
} else {
}






$con->close();
