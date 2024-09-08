BIN=TestJavaDev

SRCS=src/TestJavaDev.java\
src/BankAccount.java\
src/Customer.java\
src/ValidaCNPJ.java\
src/ValidaCPF.java\
src/Utils.java

all: $(BIN)

$(BIN):
	mkdir -p bin
	javac -d bin $(SRCS)

run: $(BIN)
	java -cp bin $(BIN)

clean:
	rm -r bin

.PHONY: all $(BIN) run clean
