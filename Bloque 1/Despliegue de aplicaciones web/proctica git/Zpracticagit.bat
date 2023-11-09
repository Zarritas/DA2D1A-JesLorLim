mkdir actividad
cd actividad
echo "git init" >> ../practica.txt 2>&1
git init >> ../practica.txt 2>&1
echo "git log --oneline" >> ../practica.txt 2>&1
git log --oneline >> ../practica.txt 2>&1
echo "git shortlog -s" >> ../practica.txt 2>&1
git shortlog -s 2>> ../practica.txt 2>&1
echo "git show" >> ../practica.txt 2>&1
git show >> ../practica.txt 2>&1
echo "git branch" >> ../practica.txt 2>&1
git branch >> ../practica.txt 2>&1
echo "git branch bifurca" >> ../practica.txt 2>&1
git branch bifurca  >> ../practica.txt 2>&1
echo "git remote -v" >> ../practica.txt 2>&1
git remote -v  >> ../practica.txt 2>&1
echo "git fsck" >> ../practica.txt 2>&1
git fsck  >> ../practica.txt 2>&1
echo "echo a > letras " >> ../practica.txt 2>&1
echo a > letras 
echo "git status" >> ../practica.txt 2>&1
git status  >> ../practica.txt 2>&1
echo "git add letras" >> ../practica.txt 2>&1
git add letras >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1
git status  >> ../practica.txt 2>&1
echo "git rm letras " >> ../practica.txt 2>&1

git rm letras  >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1

git status  >> ../practica.txt 2>&1
echo "git rm --cached letras" >> ../practica.txt 2>&1

git rm --cached letras  >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1

git status  >> ../practica.txt 2>&1
echo "git add letras" >> ../practica.txt 2>&1

git add letras  >> ../practica.txt 2>&1
echo "git commit -m 'Creado el archivo letras.'" >> ../practica.txt 2>&1
git commit -m "Creado el archivo letras."  >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1

git status  >> ../practica.txt 2>&1
echo "git ls-tree --name-only HEAD" >> ../practica.txt 2>&1

git ls-tree --name-only HEAD  >> ../practica.txt 2>&1
echo "git ls-tree -r HEAD" >> ../practica.txt 2>&1

git ls-tree -r HEAD  >> ../practica.txt 2>&1
echo "git hash-object letras" >> ../practica.txt 2>&1

git hash-object letras >> ../practica.txt 2>&1
echo "git ls-files --stage letras" >> ../practica.txt 2>&1

git ls-files --stage letras >> ../practica.txt 2>&1
echo "echo b>> letras" >> ../practica.txt 2>&1

echo b >> letras
echo "git add letras" >> ../practica.txt 2>&1
git add letras >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1
git status >> ../practica.txt 2>&1
echo "echo c >> letras" >> ../practica.txt 2>&1

echo c >> letras
echo "git status" >> ../practica.txt 2>&1
git status >> ../practica.txt 2>&1
echo "git log --oneline" >> ../practica.txt 2>&1

git log --oneline >> ../practica.txt 2>&1
echo "git checkout HEAD^" >> ../practica.txt 2>&1

git checkout HEAD^ >> ../practica.txt 2>&1
echo "git shortlog -sne" >> ../practica.txt 2>&1

git shortlog -sne  >> ../practica.txt 2>&1
echo "git show HEAD" >> ../practica.txt 2>&1

git show HEAD >> ../practica.txt 2>&1
echo "git branch" >> ../practica.txt 2>&1

git branch >> ../practica.txt 2>&1
echo "git fsck" >> ../practica.txt 2>&1

git fsck >> ../practica.txt 2>&1
echo "git commit -m 'Modificado el directorio letras.'" >> ../practica.txt 2>&1

git commit -m "Modificado el directorio letras." >> ../practica.txt 2>&1
echo "git show" >> ../practica.txt 2>&1

git show >> ../practica.txt 2>&1
echo "git commit --amend -m 'Modificado el archivo letras.'" >> ../practica.txt 2>&1

git commit --amend -m "Modificado el archivo letras." >> ../practica.txt 2>&1
echo "echo "a\n\nc" > letras" >> ../practica.txt 2>&1

echo "a\n\nc" > letras
echo "1,3,5\n2,4,6" > numeros
echo "git add letras numeros" >> ../practica.txt 2>&1
git add letras numeros >> ../practica.txt 2>&1
echo "git show" >> ../practica.txt 2>&1
git show >> ../practica.txt 2>&1
echo "git commit -m 'Modificado el archivo letras y añadido el archivo números.'" >> ../practica.txt 2>&1

git commit -m "Modificado el archivo letras y añadido el archivo números." >> ../practica.txt 2>&1
echo "git show" >> ../practica.txt 2>&1

git show >> ../practica.txt 2>&1
echo "git show HEAD:numeros" >> ../practica.txt 2>&1

git show HEAD:numeros >> ../practica.txt 2>&1
echo "git diff HEAD HEAD~1" >> ../practica.txt 2>&1

git diff HEAD HEAD~1 >> ../practica.txt 2>&1
echo "git diff HEAD HEAD^" >> ../practica.txt 2>&1

git diff HEAD HEAD^ >> ../practica.txt 2>&1
echo "echo "1,3,5,7,9\n2,4\n\n30,20,10"" >> ../practica.txt 2>&1

echo "1,3,5,7,9\n2,4\n\n30,20,10" > numeros
echo "git commit -am 'Retocado el archivo numeros'" >> ../practica.txt 2>&1
git commit -am "Retocado el archivo numeros" >> ../practica.txt 2>&1
echo "" >> ../practica.txt 2>&1

git log --oneline --graph --all  >> ../practica.txt 2>&1
echo "git reset --hard HEAD^" >> ../practica.txt 2>&1

git reset --hard HEAD^ >> ../practica.txt 2>&1
echo "git fsck" >> ../practica.txt 2>&1

git fsck >> ../practica.txt 2>&1
echo "git branch ramifica" >> ../practica.txt 2>&1

git branch ramifica >> ../practica.txt 2>&1
echo "git branch -m ramifica bifurca" >> ../practica.txt 2>&1

git branch -m ramifica bifurca >> ../practica.txt 2>&1
echo "echo '!\n,\n.\n$' > simbolos" >> ../practica.txt 2>&1

echo "!\n,\n.\n$" > simbolos
echo "git switch -f bifurca" >> ../practica.txt 2>&1
git switch -f bifurca >> ../practica.txt 2>&1
echo "git add simbolos" >> ../practica.txt 2>&1

git add simbolos >> ../practica.txt 2>&1
echo "dir" >> ../practica.txt 2>&1
dir >> ../practica.txt 2>&1
echo "git switch -f main" >> ../practica.txt 2>&1

git switch -f main >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1

git status >> ../practica.txt 2>&1
echo "git add simbolos" >> ../practica.txt 2>&1

git add simbolos >> ../practica.txt 2>&1
echo "git commit -m 'Añadido el archivo simbolos'" >> ../practica.txt 2>&1
git commit -m "Añadido el archivo simbolos" >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1

git status >> ../practica.txt 2>&1
echo "dir" >> ../practica.txt 2>&1

dir >> ../practica.txt 2>&1
echo "git switch -f bifurca" >> ../practica.txt 2>&1

git switch -f bifurca >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1

git status >> ../practica.txt 2>&1
echo "dir" >> ../practica.txt 2>&1

dir >> ../practica.txt 2>&1
echo "echo '%\n/\n='" >> ../practica.txt 2>&1

echo "%\n/\n=" > simbolos
echo "git status" >> ../practica.txt 2>&1
git status >> ../practica.txt 2>&1
echo "git add simbolos" >> ../practica.txt 2>&1

git add simbolos >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1
git status >> ../practica.txt 2>&1
echo "git log --oneline" >> ../practica.txt 2>&1

git log --oneline >> ../practica.txt 2>&1
echo "git switch -f main" >> ../practica.txt 2>&1

git switch -f main >> ../practica.txt 2>&1
echo "git log --oneline" >> ../practica.txt 2>&1

git log --oneline >> ../practica.txt 2>&1
echo "git log --oneline --all -graph" >> ../practica.txt 2>&1

git log --oneline --all --graph >> ../practica.txt 2>&1
echo "git switch -f bifurca" >> ../practica.txt 2>&1

git switch -f bifurca >> ../practica.txt 2>&1
echo "git log --oneline --all --graph" >> ../practica.txt 2>&1

git log --oneline --all --graph >> ../practica.txt 2>&1
echo "git switch -f main" >> ../practica.txt 2>&1

git switch -f main >> ../practica.txt 2>&1
echo "echo 'una línea' > nuevo_en_main" >> ../practica.txt 2>&1

echo "una línea" > nuevo_en_main
echo "git add nuevo_en_main" >> ../practica.txt 2>&1
git add nuevo_en_main >> ../practica.txt 2>&1
echo "echo 'otra línea' >> nuevo_en_main" >> ../practica.txt 2>&1
echo "otra línea" >> nuevo_en_main
echo "git status -s" >> ../practica.txt 2>&1
git status -s >> ../practica.txt 2>&1
echo "type nuevo_en_main" >> ../practica.txt 2>&1

type nuevo_en_main >> ../practica.txt 2>&1
echo "dir" >> ../practica.txt 2>&1

dir >> ../practica.txt 2>&1
echo "git stash" >> ../practica.txt 2>&1

git stash >> ../practica.txt 2>&1
echo "dir" >> ../practica.txt 2>&1

dir >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1

git status >> ../practica.txt 2>&1
echo "git stash pop" >> ../practica.txt 2>&1

git stash pop >> ../practica.txt 2>&1
echo "git stash clear" >> ../practica.txt 2>&1

git stash clear >> ../practica.txt 2>&1
echo "dir" >> ../practica.txt 2>&1

dir >> ../practica.txt 2>&1
echo "git status" >> ../practica.txt 2>&1

git status >> ../practica.txt 2>&1
echo "git merge bifurca" >> ../practica.txt 2>&1

git merge bifurca >> ../practica.txt 2>&1
echo "git merge --no-ff bifurca" >> ../practica.txt 2>&1

git merge --no-ff bifurca >> ../practica.txt 2>&1
echo "git log --oneline" >> ../practica.txt 2>&1

git log --oneline >> ../practica.txt 2>&1
echo "git log --oneline --graph --all --follow -p -- simbolos" >> ../practica.txt 2>&1

git log --oneline --graph --all --follow -p -- simbolos  >> ../practica.txt 2>&1
echo "type letras" >> ../practica.txt 2>&1

type letras >> ../practica.txt 2>&1
echo "git restore HEAD^^^ letras" >> ../practica.txt 2>&1

git restore HEAD^^^ letras >> ../practica.txt 2>&1
echo "" >> ../practica.txt 2>&1

echo "echo "No sé qué será de mi vida" > mar_de_dudas" >> ../practica.txt 2>&1

echo "No sé qué será de mi vida" > mar_de_dudas
echo "git status" >> ../practica.txt 2>&1
git status >> ../practica.txt 2>&1
echo "echo mar_de_dudas > .gitignore" >> ../practica.txt 2>&1

echo mar_de_dudas > .gitignore
echo "git status" >> ../practica.txt 2>&1
git status >> ../practica.txt 2>&1
echo "git add ." >> ../practica.txt 2>&1

git add . >> ../practica.txt 2>&1
echo "git commit -m 'Cosas que se debian confirmar'" >> ../practica.txt 2>&1
git commit -m "Cosas que se debian confirmar" >> ../practica.txt 2>&1

echo "git log --oneline --graph --all" >> ../practica.txt 2>&1
git log --oneline --graph --all >> ../practica.txt 2>&1
