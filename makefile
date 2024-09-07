PROGRAM=MainExec

SRCS=src/MainExec.java\

build: ${SRCS}
	@ mkdir -p bin
	javac ${SRCS} -d ./bin

run: build
	@ java -cp bin ${PROGRAM}
