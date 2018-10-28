<!DOCTYPE html>
<html>
<body>
	<h2>lolcounter-rest Web Application!</h2>
	<p>
		<a href="webapi/champion">Champion resource</a> <a
			href="webapi/tip/all">Tip resource</a>
	</p>
	<div>
		<p>form</p>
		<form action="webapi/tip/form" method="post">
			<input type="text" name="name" value='Warwick' placeholder="Enter name" /> <input
				type="submit" value="submit" />
		</form>

	</div>
	<div>
		<p>query</p>
		<form action='webapi/tip/query' method='get'>
			<input type='text' name='name' value='Warwick' placeholder='Enter name' /> <input
				type='submit' value='submit' />
		</form>
	</div>
</body>
</html>
