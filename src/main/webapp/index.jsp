<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>User Form</title>

</head>
<body>
<div id="container">
<form action="hello" method="POST">
    Name: <input type="text" name="username" />
    <br><br>
    Age: <input type="text" name="userage" />
    <br><br>
    Gender:
    <input type="radio" name="gender" value="female" checked>Female
    <input type="radio" name="gender" value="male">Male
    <br><br>
    Country:
    <select name="country">
        <option>Canada</option>
        <option>Spain</option>
        <option>France</option>
        <option>Germany</option>
    </select>
    <br><br>
    Courses:
    <input type="checkbox" name="courses" value="JavaSE" checked>Java SE
    <input type="checkbox" name="courses" value="JavaFX">Java FX
    <input type="checkbox" name="courses" value="JavaEE">Java EE
    <br><br>
    <input type="submit" value="Submit" />
</form>
</div>
</body>
</html>