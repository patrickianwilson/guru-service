# guru-service
The "Guru" system is a lightweight cloud agnostic deployment tool.  It is designed to run in app engine (near zero operational overhead) but makes
calls to any cloud.  The service is "stateful" in that is records the outcomes of all operation into the App Engine datastore.  

How Is This Different From Traditional Approaches?
=================================================
Traditionally DevOps teams will fall into one of two camps.  Either they prefer to leverage a PaaS that is hands off (such as app engine) which work very well 
until there is a need to implement a feature that is really tough to complete when the infrastructure cannot be controlled.  
The second camp prefers to maintain control of the infrastructure at all times.  However (in my experience) the "PaaS" that these teams create tend
to be very Ops centric in that they are often not written and maintained by developers (in code) but rather by System Administrators (in scripts).

The script form of PaaS will fail often because it does not maintain state.  Logically, applications consist of intrastructure + code + configuration.  Each of those
components may be updated in isolation of each other.  Understanding what is meant by a "rollback" becomes very complicated if data around the current
state of each of those components is not recorded.  Infact - recording all those component states in script format leads to complex and difficult 
to maintain script code.

The popularity of systems such as Spinnaker demonstrate the desire to have a Platform service that is written as an application rather an a collection
of scripts.  However, Spinnaker does a lot of things and is fairly opinionated.  Guru, in contrast, attempts to be as simple as possible and 
encourages teams to simply modify the code and redploy in appengine.  It does not attempt to manage any integration with CI servers or define infrastructure
in flexible config files as these can often be written and tested in code rather easily if the originating code base is simple enough.

What Does Guru Do?
==================
* Manage a "deployment stack" that can be easily rolled back on problems
* Manage creation of new "applications" on demand
* Manage uploading of new "versions" of code
* Manage configuration of environments in an idempotant and auditable manner
* Provides API support for all of the above.

What Does Guru NOT Do?
======================
* Pipeline managment
* Test facilitation
* Complex infrastructure configuration definition files
* Identity Federation
* Simple User Interface for system administrators.  The application is equipted with Swagger out of the box, that is intended to be the UI.
