   class HashTable{
      private DataItem[] hashArray;
      private int arraySize;
      private DataItem nonItem;
      private float averageprobelength;
      
      public HashTable(int size){
         arraySize = size;
         hashArray = new DataItem[arraySize];
        // nonItem = new DataItem(" "); used for deleting hash numbers to place a filler
      }
  
//--------------------------------------------------------------------
   public void setAverageProbeLength(int size){
      float avProbeLength = 0;
      for(int j=0; j<arraySize; j++){
         
            if(hashArray[j] != null){
             avProbeLength = avProbeLength + hashArray[j].getProbelength();
            }
     }
     averageprobelength = avProbeLength/size;
   }
//----------------------------------------------------------------------
   public float getAverageProbeLength(){
      return averageprobelength;
   }
//------------------------------------------------------------------
       public int hashFunc(String key){
         int hashVal =0;
         for(int j =0; j<key.length(); j++){
         
            int letter = key.charAt(j);
            hashVal = (hashVal*26 + letter) % arraySize;
         }
         return hashVal; // hash function
       }

      
//--------------------------------------------------------------

   public void insertQuad(DataItem item){
      
      String key = item.getKey(); // extract key
         
         int hashVal = hashFunc(key); // hash the key
         int quadjump = 1;
         int hashtemp = hashVal;
         int probelength = 1;
         // until empty cell or -1,
         
         while(hashArray[hashVal] != null){
            item.setCollisionValue(true);
            hashtemp = (hashtemp + quadjump * quadjump++); // go to next cell
            hashtemp %= arraySize; // wraparound if necessary
            hashVal= hashtemp;
            probelength++;
         }
         
         hashArray[hashVal] = item; // insert item
         hashArray[hashVal].setProbelength(probelength);
   }
       
///---------------------------------------------------------------------------------
    
 public DataItem quadFind(DataItem value){
            int probelength = 1;
            int quadjump =1;
            
            int hashVal = hashFunc(value.getKey()); // hash the key
            int hashtemp = hashVal;
            while(hashArray[hashVal] != null){ // found the key?
               
               if(hashArray[hashVal].getKey().equals(value.getKey())){
                  value.setProbelengthFind(probelength);//maybe be repetitive may need to REMOVE!!!!!
                  value.setArrayPlace(hashVal);
                  return hashArray[hashVal];
               } // yes, return item
               hashtemp =(hashtemp + quadjump * quadjump++); 
               hashtemp %= arraySize;
               hashVal = hashtemp;
               probelength++; // wraparound if necessary
            }
            value.setProbelengthFind(probelength);
            value.setArrayPlace(hashVal);
            return null; // can’t find item
         } 

  }