# Morse-Code-Translator
A program that can take in string/character or text file inputs from the command line and output the corresponding Morse Code. When you start the program you will be greeted with the following text as shown below:

```
Failed to open file: Non_Existing_File.bad

Got an invalid line: ;;--..--.
Got an invalid line: AB
Got an invalid line: ~
The character \ with conversion ..... is invalid
The character ` with conversion -- is invalid
The character ^ with conversion - is invalid

Select one of the following choices: 
  1. Print conversion codes
  2. Convert character.
  3. Convert string.
  4. Convert file.
  5. Exit.
Choice(1-5): 
```

The first line served as a test case for opening unsupported files, and the following lines are the invalid characters and lines being parsed out of a text file containing morsecode conversions for characters. The user will have 5 options to choose from, and each option is explained below:

Choice 1) Print every *valid* character and its corresponding morsecode in a table format.

Choice 2) After inputting a character, the corresponding morsecode for that character will be outputted. 

Choice 3) After inputting a string, the corresponding morsecode for that string will be outputted. 

Choice 4) A text file must be in the project directory, after which you can type in the name of the file for this choice and the morsecode conversion for that entire             text file will be outputted. Question marks (?) will be printed for unsupported characters. 

Choice 5) Choosing this option will simply terminate the program. 


# Examples
You can test the correctness of the program by comparing the outputs shown below with this online [morsecode translator](https://morsecode.world/international/translator.html) 


https://user-images.githubusercontent.com/80434026/171079328-42c9d872-f159-4e81-919d-ede1222c803b.mp4



