<!doctype html>
<html lang="en">
<head>
    <title>Home</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css" >
    <link rel="stylesheet" href="css/style.css">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light background">
    <a class="navbar-brand text-white" href="#">PDF Generator</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        </ul>
        <button class="btn btn-outline-success my-2 my-sm-0 mr-3" type="submit">Sign up</button>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign in</button>
    </div>
</nav>
<div class="container">
    <div class="content text-color">
        <form action="/home" method="post">
            <div class="row">
                <div class="col">
                    <input type="text" class="form-control" placeholder="First name" name="name">
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Last name" name="lastname">
                </div>
            </div>
            <div class="form-group">
                <label for="activityName">Activity name</label>
                <input type="text" class="form-control" id="activityName" placeholder="acitivity" name="activityName">
            </div>
            <div class="form-group">
                <label for="courseName">Course</label>
                <input type="text" class="form-control" id="courseName" placeholder="course" name="courseName">
            </div>
            <div class="form-group">
                <label for="url">URL</label>
                <input type="text" class="form-control" id="url" placeholder="url address" name="url">
            </div>
            <div class="form-group">
                <label for="date">Date</label>
                <input class="form-control" type="date" value="2018-02-03" id="date" name="date">
            </div>
            <button type="submit" class="btn btn-primary">Get certificate</button>
        </form>

    </div>
</div>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap-formhelpers-phone.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
</body>
</html>