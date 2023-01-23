/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package speech.to.text;

import com.sun.speech.freetts.*;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;

/**
 *
 * @author mearjuntripathi
 */
public class SpeechToText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //First we create a Voice Speaker one who speak.
        
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.allocate();
        voice.setPitch(70);
        voice.setRate(150);
        voice.setVolume(10);           
        String value = "Hi Sir I'm Ready to work for you";
        boolean status = voice.speak(value);
        System.out.println("status: "+ status);
        
        
        //starting a Configuration for voice recognization thing.
        
        Configuration configuration = new Configuration();
        
        //this is a Acoustic Model Path
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("/home/mearjuntripathi/NetBeansProjects/Speech To Text/src/com/voicerecognization/resources/corpus.dic");
        configuration.setLanguageModelPath("/home/mearjuntripathi/NetBeansProjects/Speech To Text/src/com/voicerecognization/resources/corpus.lm");
        
        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
        
        recognize.startRecognition(true);
        
        SpeechResult speechResult;
        
        while((speechResult = recognize.getResult()) != null){
            String command = speechResult.getHypothesis();
            System.out.println("input Command :"+ command);   
        }
    }   
}
