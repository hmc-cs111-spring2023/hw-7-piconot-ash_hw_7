# Design

## Who is the target for this design, e.g., are you assuming any knowledge on the part of the language users?

It is for POLITE users that want better variable/function names for states than just "0" or "1". It is hard to keep track of what each state is. 
It also gives more variation on what sort of direction calls you make. You can say "up" or "North" or "N" -> any variation will work.

The DSL allows you to access this features such as having text variable/function names and a more open syntax - as long as you are polite to the picobot. 

What does being polite mean? Using magic words like "please". Instead of ending each line of code with a semicolon, the user must end it with a happy ASCII emoji or a "thank you" followed by a ":)" emoji. 

So, the target audience is those that want an easier language, and are willing to be polite and use emojis to get it. If you are polite, you get the features.

## Why did you choose this design, i.e., why did you think it would be a good idea for users to express the maze-searching computation using this syntax?

The picobot works very hard, and it would appreciate cute emojis and magic words.

It is good for the users because remembering several states is very hard. State "0", state "1", etc. etc. can get very hard to follow. Using "goBottom1" is an easier state name since it explains what that state is doing. It is like a variable/function name.

North/N/up also makes it easier for the user. They can use the syntax they are comfortable with and have more options.


## What behaviors are easier to express in your design than in Picobot’s original design?  If there are no such behaviors, why not?

 It is largely the same functionality - just a more fluid syntax, better state names and cuter semicolons. And of course, polite grammar.

## What behaviors are more difficult to express in your design than in Picobot’s original design? If there are no such behaviors, why not?

It is largely the same functionality - just a more fluid syntax, better state names and cuter semicolons. And of course, polite grammar.

## On a scale of 1–10 (where 10 is “very different”), how different is your syntax from PicoBot’s original design?

Humble 5. I had some more ideas, but I could only add 4 different features.

## Is there anything you would improve about your design?

I wanted to add some more control features, and some more natural language options. I spent a lot of time on the former, but couldnt get it working. Also, right now names must end in a unique integer. For instance,"calib1" - but I would like to remove that limitation. My current implementation still allows the user to have unique state names, while allowing me to use a regex. But the integers might be hard to remember. 