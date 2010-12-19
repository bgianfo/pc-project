LATEX=latex
BIBTEX=bibtex
CONVERT_DVI=dvipdf

default: clean paper paper-clean

open:
	open paper.pdf

paper: paper.tex
	$(LATEX) paper
	#$(BIBTEX) paper
	$(LATEX) paper
	$(LATEX) paper
	$(CONVERT_DVI) paper.dvi
	open paper.pdf

paper-clean:
	rm -f paper.dvi
	rm -f paper.aux
	rm -f paper.log
	rm -f paper.toc
	rm -rf paper.bbl
	rm -rf paper.blg
	rm -rf missfont.log

# Check style:
proof:
	@echo "weasel words: "
	@./bin/weasel *.tex
	@echo ""
	@echo "duplicates: "
	./bin/dups *.tex
	@echo ""
	@echo "passive voice: "
	./bin/passive *.tex

detex:
	@detex paper.tex > .detex


diction: detex
	diction -L en -b -s .detex | fmt

style: detex
	style -n -N .detex | fmt

rmdetex: style diction
	@rm .detex

spell:
	aspell check -t paper.tex

clean: paper-clean
	rm -rf paper.pdf
