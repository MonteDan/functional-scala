Just solving Leetcode and Hackerrank problems in Scala to improve at functional programming

## SETUP ENVIRONMENT (Linux)
Make the file called `setup` executable
```bash
chmod +x setup
```
Execute setup
```bash
./setup
```

## COMMANDS
#### RUN A SCRIPT
```bash
./r name  # => scala ./problems/name.scala
```

## USEFUL SNIPPETS
#### PIPELINE OPERATOR
```scala
implicit class Pipe[A](val a: A) extends AnyVal {
  def |>[B](f: A => B): B = f(a)
}
```