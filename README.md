# File_Mis-match
<h2>Problem Statement - </h2>
Sometimes you download files from cloud or clone something or copy paste files or an entire folder then some files remain empty or they get missed while copying.
So you spend hours finding the files and downloading manually.

<h2>Solution - </h2>
This script can be used to solve this problem. Using longest common subsequece you can compare two files and find the ones which are missing or are not completely copied.

<h2>How it works - </h2>
Code to find longest common subsequence length can be found <a href = "https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/"> here </a>
and finding longest common subsequence is <a href = "https://www.geeksforgeeks.org/printing-longest-common-subsequence/">here </a>
there is also a space optimised version but I haven't used it in my code but can surely do so.

<h2>Now working - </h2>
We have two files each file contains objects. These objects contains data about file including file path, size, name etc which is present inside a specific folder and it's subfolders.
For simplicity I have taken two files, each line in these files contains a file name and size sepearted by space.
Then created objects for each file and stored in two lists one for source and other for destination.
In this script a user just have to give two file names written in above mentioned format.
