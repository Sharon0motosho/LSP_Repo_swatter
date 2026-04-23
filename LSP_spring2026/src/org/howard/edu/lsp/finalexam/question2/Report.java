package org.howard.edu.lsp.finalexam.question2;


abstract class Report {

 public final void generateReport() {
     loadData();
     formatHeader();
     formatBody();
     formatFooter();
 }

 protected abstract void loadData();
 protected abstract void formatHeader();
 protected abstract void formatBody();
 protected abstract void formatFooter();
}
