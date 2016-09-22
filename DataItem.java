   class DataItem{
      private String iData; 
      private int value;
      private int probelength;
      private int probelengthfind;
      private int probelengthdelete;
      private int arrayPlace;
      private boolean collision = false;
      
      public DataItem(String i){//parse string into word and number
         String temp = i;
         String[] divide = temp.split("\\s");
         iData = divide[0];
         if(divide.length > 1){
            value = Integer.parseInt(divide[1]);
         }
         else{
            value = -1;
         }
      }
      public String getKey(){
         return iData;
      }
      public void setProbelength(int probe){
         probelength = probe;
      }
      public int getProbelength(){
         return probelength;
      }
      public void setProbelengthFind(int probe){
         probelengthfind = probe;
      }
      public int getProbelengthFind(){
         return probelengthfind;
      }
      public void setProbelengthDelete(int probe){
         probelengthdelete = probe;
      }
      public int getProbelengthDelete(){
         return probelengthdelete;
      }
      public int getValue(){
         return value;
      }
      public void setArrayPlace(int place){
         arrayPlace = place;
      }
      public int getArrayPlace(){
         return arrayPlace;
      }
      public void setCollisionValue(boolean value){
         collision = value;
      }
      public boolean getCollisionValue(){
         return collision;
      }
   }