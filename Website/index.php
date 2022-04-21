<!--

 ______     ______     ______   ______     __  __     ______     __  __
/\  == \   /\  ___\   /\__  _\ /\  __ \   /\ \/ /    /\  ___\   /\ \_\ \
\ \  __<   \ \  __\   \/_/\ \/ \ \  __ \  \ \  _"-.  \ \  __\   \ \____ \
 \ \_____\  \ \_____\    \ \_\  \ \_\ \_\  \ \_\ \_\  \ \_____\  \/\_____\
  \/_____/   \/_____/     \/_/   \/_/\/_/   \/_/\/_/   \/_____/   \/_____/
  by @HyplexMC

-->

<?php
session_start();

require "/other/main.css";
require "/other/inded.js";

?>


<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Basic Page -->
    <meta charset="utf-8">
    <title>HyplexMC BetaKey</title>
    <meta name="description" content="Redeem BetaKey">
    <meta name="author" content="HyplexMC">

    <!-- Mobile Specific Metas-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
            integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
            crossorigin="anonymous"></script>

    <!-- libs -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Materialize -->
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


</head>
<body>


<div class="floatcenter">
    <div class="center">

        <?php
        if (isset($_GET['name']) && isset($_GET['key'])) {
            $name = $_GET['name'];
            $key = $_GET['key'];

            $db = new PDO('mysql:host=localhost;dbname=DATABASE', 'USERNAME', 'PASSWORD');

            $getKey = $db->prepare("SELECT * FROM betakey WHERE BETAKEY=?");
            if ($getKey->execute(array($key))) {
                if ($getKey->rowCount() < 1) {
                    echo "<h1>
                      <i class='fas fa-lock'></i><br>BetaKey
                    </h1>
                    <h5>
                      Reedem your BetaKey for luis.team here!
                    </h5>
                    <br>

                  </center>


                    <form action=''>
                      <div class='form-group'>
                        <input type='username' class='form-control' name='name' placeholder='Enter Minecraft name' maxlength='16' minlength='3' required>
                      </div>
                      <div class='form-group'>
                        <input type='key' class='form-control' name='key' placeholder='Enter BetaKey' maxlength='22' minlength='22' required>
                      </div>
                      <center>
                        <button type='submit' class='submitBtn'><i class='fas fa-key'></i></button>
                      </center>
                    </form>

                  <div class='alert'>
                          <span class='closebtn' id='closebutton'><i class='fas fa-times'></i></span>
                          <strong><i class='fas fa-exclamation-triangle'></i></strong> Try again!
                        </div>";
                } else {
                    include './mc-api.php';

                    $insertUser = $db->prepare("INSERT INTO betaplayer VALUES(?, ?)");
                    if ($insertUser->execute(array(username_to_uuid($name), $key))) {
                        echo "<h1>
                      <i class='fas fa-unlock'></i><br>BetaKey
                    </h1>
                    <br>


                    <h3><i class='far fa-check-circle succes_icon'></i> You are unlocked!<h3>
                    <h4>You can join our server</h4>";

                        while ($row = $getKey->fetch()) {
                            $PERMANENT = $row['PERMANENT'];
                            $USES = $row['USES'];

                            if ($PERMANENT == 0) {
                                $deleteKey = $db->prepare("DELETE FROM betakey WHERE BETAKEY=?");
                                $deleteKey->execute(array($key));
                            } else {
                                $updateUses = $db->prepare("UPDATE betakey SET USES=?");
                                $updateUses->execute(array($USES + 1));
                            }

                        }


                    } else {
                        echo "<div class='alert'>
                          <span class='closebtn' id='closebutton'><i class='fas fa-times'></i></span>
                          <strong><i class='fas fa-exclamation-triangle'></i> SQL EXCEPTION</strong> RELOAD THE PAGE AND TRY AGAIN!<br>"
                            . $insertUser->errorInfo()[2] .
                            "</div>";
                    }

                }

            } else {
                echo "<div class='alert'>
                      <span class='closebtn' id='closebutton'><i class='fas fa-times'></i></span>
                      <strong><i class='fas fa-exclamation-triangle'></i> SQL EXCEPTION</strong> RELOAD THE PAGE AND TRY AGAIN!<br>"
                    . $getKey->errorInfo()[2] .
                    "</div>";
            }


        } else {
            echo "<h1>
                <i class='fas fa-lock'></i><br>BetaKey
              </h1>
              <h5>
                Redeem your BetaKey for luis.team here!
              </h5>
              <br>

            </center>


              <form action=''>
                <div class='form-group'>
                  <input type='username' class='form-control' name='name' placeholder='Enter Minecraft name' maxlength='16' minlength='3' required>
                </div>
                <div class='form-group'>
                  <input type='key' class='form-control' name='key' placeholder='Enter BetaKey' maxlength='22' minlength='22' required>
                </div>
                <center>
                  <button type='submit' class='submitBtn'><i class='fas fa-key'></i></button>
                </center>
              </form>";
        }


        ?>

    </div>

</div>

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>
