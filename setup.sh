echo "Setting up for development"
echo "__________________________"







### COMPILE UTILS
rm -rf utils

scalaUtils=$(find ./utils-src -name "*.scala")

utilNames=()

for file in $scalaUtils
do
  utilNames+=("$(basename $file)")
done

echo "Compiling utils from:"
printf "%s, " "${utilNames[@]}"
echo

# Loading
loadingChars=( '⠁' '⠁' '⠉' '⠙' '⠚' '⠒' '⠂' '⠂' '⠒' '⠲' '⠴' '⠤' '⠄' '⠄' '⠤' '⠠' '⠠' '⠤' '⠦' '⠖' '⠒' '⠐' '⠐' '⠒' '⠓' '⠋' '⠉' '⠈' '⠈' )
while :; do
  for char in "${loadingChars[@]}"; do
    echo -ne "\r$char" # Use the same line, and output char
    sleep .1
  done
done &

loadingProcessID=$!

scalac $scalaUtils

# Kill Loading
kill $loadingProcessID

### MAKE RUN SCRIPT EXECUTABLE
chmod +x r