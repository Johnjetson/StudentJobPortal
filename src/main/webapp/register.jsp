<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="auth-container">

        <div class="auth-box register-box">

            <h1>Create Account</h1>

            <p class="auth-subtitle">
                Register as a student
            </p>

            <form action="RegisterServlet" method="post">

                <label>Name</label>
                <input type="text"
                       name="name"
                       placeholder="Enter your full name"
                       required>
                       
				<label>Email</label>
                <input type="email"
       				name="email"
       				placeholder="Enter your email"
       				pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"
       				title="Enter a valid email address"
       				required>

                <label>Password</label>
                <input type="password"
       					name="password"
       					placeholder="Create a password"
       					minlength="8"
       					title="Password must contain at least 8 characters"
       					required>
       					
       			<label>Confirm Password</label>

				<input type="password"
       					name="confirmPassword"
       					placeholder="Re-enter your password"
       					minlength="8"
       					required>

                <label>Phone</label>
                <input type="text"
       				name="phone"
      				placeholder="Enter 10-digit phone number"
       				pattern="[0-9]{10}"
       				maxlength="10"
       				title="Phone number must contain exactly 10 digits"
       				required>

                <label>Department</label>
                <input type="text"
                       name="department"
                       placeholder="Example: Computer Science"
                       required>

                <label>Graduation Year</label>
                <input type="number"
       				name="graduationYear"
       				placeholder="Example: 2027"
       				min="2020"
       				max="2035"
       				required>

                <button type="submit">
                    Create Account
                </button>

            </form>

            <p class="auth-footer">
                Already have an account?
                <a href="login.jsp">Login</a>
            </p>

            <p class="auth-footer">
                <a href="index.html">← Back to Home</a>
            </p>

        </div>

    </div>

</body>

</html>