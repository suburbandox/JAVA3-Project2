<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>The Adding App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container my-4">
    <div class="row">
        <div class="col-3">
            <h1>Add</h1>
            <p class="lead">Enter two numbers and press submit to calculate the sum.</p>
            <%-- The action attribute must be the path to the servlet --%>
            <form method="POST" action="add">
                <div class="form-group mb-2">
                    <label for="firstNumber">First Number:</label>
                    <input type="text" class="form-control" id="firstNumber" name="firstNumber">
                </div>
                <div class="form-group mb-2">
                    <label for="secondNumber">Second Number:</label>
                    <input type="text" class="form-control" id="secondNumber" name="secondNumber">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>