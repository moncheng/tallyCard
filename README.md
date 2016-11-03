## Tally System
A simple practice project that uses Spring and Angular frameworks. Tally System is a webapp for progress checking, voting , or counter of anysort of things.


## Things to install

  * MongoDB
  	* Install
	  	* https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/
		  You can install it via homebrew which is easiest way. (to install home-brew check optionals section).
		  simply run `brew update`, and then `brew install mongodb`.
		* `sudo mkdir -p /data/db` to create default db directory.
		* run `export PATH=$PATH:/data/db` to add path varible ( may need start new session of shell or restart terminal to take effect)

	* Run
		* simply run `mongod` may need to run with sudo if your user dont have root access.
	* Running Mongo Shell
		* `mongo`
			* `db` to check the database you are in use
			default db called `test`
			* `use <database>` to switch to different db.
			* `show dbs` to see db list(note default `test` will not show).
			* `use myNewDB` to create new db.
			*  `https://docs.mongodb.com/manual/mongo/` for more information.

  * Maven
http://maven.apache.org/install.html

**optionals** 

  * home-brew 
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

  * IDE, Sprint tool suite, Eclipse or others.



## How to Run locally

	1. Run `mongod` in terminal to run DB
	2. Run `mvn clean package` and then `mvn spring-boot:run` in new terminal section to start application
	3. Run `mongo` in new section to run mongo shell if you want to check Data.
	4. Navigate to `localhost:8080` on browser.