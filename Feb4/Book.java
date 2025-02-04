class Book{
        static String libraryName="The Book World";
        String title;
	String author;
        final int isbn;
        Book(String title, String author, int isbn){
                this.title=title;
                this.author=author;
                this.isbn=isbn;
        }
        public static void displayLibraryName(){
                System.out.println("The library name is:" +libraryName);
        }
        public static void main(String args[]){
                Book object=new Book("The Secret", "Robert", 456281);
                new Book("Percy Jackson", "Rick", 127193);
                if(object instanceof Book){
                        System.out.println("account object is an instance of the BankAccount");
                }
                Book.displayLibraryName();
        }
}
