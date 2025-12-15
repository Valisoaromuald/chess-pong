// package projetEchecPong.controllers;

// import javafx.event.EventHandler;
// import javafx.scene.Scene;
// import javafx.scene.control.TextField;
// import javafx.scene.input.MouseEvent;
// import javafx.scene.text.Text;
// import projetEchecPong.models.jeu.Echiquier;
// import projetEchecPong.views.EchiquierView;

// public class ConfigurationVieController  implements EventHandler<MouseEvent>{
//     // private Scene scene ;
//     private Text text;
    

//     public Text getText() {
//         return text;
//     }

//     public void setText(Text text) {
//         this.text = text;
//     }

//     @Override
//     public void handle(MouseEvent me){
        
//                 try {
//                     boolean allFiled = tousLesChampsRemplis(listeTextField);
//                     if(sc != null){
//                         if(allFiled){
                            
//                             Echiquier ech = new Echiquier(120.0, 120.0, 8, nombrePiece, 640.0, 640.0);
//                             EchiquierView echV = new EchiquierView(ech);
//                             echV.setStyle("-fx-background-color: brown;");
//                             System.out.println("eto indray hoe: "+ech.getCentreGravite());
//                             sc.setRoot(echV);
//                         }
//                         else{ 
//                             text.setText("fenoy daholo ny point de vie");
//                             return;
//                         }
//                     }
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                     text.setText(e.getMessage());
//                 }
//     }
// }
