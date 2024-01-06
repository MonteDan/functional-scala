if [ -z "$1" ]
then
    echo "No argument supplied. Please provide the scala file name."
    exit 1
fi

# Run the scala file
scala ./problems/$1.scala