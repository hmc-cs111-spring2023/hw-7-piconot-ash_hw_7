# Evaluation: running commentary

## Internal DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

## External DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

3. 
I wanted to allow clean names such as "moveTop" but that was hard to implement, so I had to force an integer at the back - "moveTop3". This still allows the user to have unique state names, while allowing me to use a regex. 

I also wanted to add some extra control, and some natural language syntax but that felt like way too much considering I was already adding some other features like state names, open direction syntax, polite grammar, emojis in place of semicolons, etc.

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

5. 
Once I got the hang of using the parser and combinators, it wasn't too bad. Especialy after I added the integer requirement for names. It took me a few hours to figure out the workings of all the parser symbols to a level at which I was confident.

I also had a rough time with pulling lines from text files, and so - used provided sample code.
