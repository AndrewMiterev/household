# Household Photo Archive

<p> 
This project is designed to maintain a family photo archive (photo album).
</p>

All cameras, phones of all family members can upload photos to this 
software, and it maintains a general family photo archive (photo album).

The "archive" consists of 3 parts:
<li>cloud database of families (a common module, does not require user configuration)</li>
<li>private cloud database of photo files</li>
<li>private slave file storage</li>

The database is located on a free MongoDB cloud storage (0.5 gigabytes), 
which is usually enough for about 1,000,000 photo files. 

How file storage can be used: 
<li>a NAS with Internet access</li>
<li>any cloud storage (such as Apple, Google, etc.)</li>

<p>
Both back-end and front-end modules are combined in one repository.
</p>

Back-end: Spring, Mongo.

Front-end: Angular.
