package com.example.croma.navigation_draw.Fragments.Tabs;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.croma.navigation_draw.R;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.Theme;

public class Tab_code extends Fragment implements CodeView.OnHighlightListener {
    CodeView mCodeView;
   // public String C_CODE = readFromFile();
    public static String TAG= Tab_code.class.getSimpleName();
    public String a = "/*\n" +
            " * exp4_interrupt.c\n" +
            " *\n" +
            " *  Created on: Oct 30, 2017\n" +
            " *      Author: DXer\n" +
            " */\n" +
            "\n" +
            "#include <avr/io.h>\n" +
            "#include <avr/interrupt.h>    // Needed to use interrupts\n" +
            "\n" +
            "#include <util/delay.h>\n" +
            "\n" +
            "int main(void)\n" +
            "{\n" +
            "\t/*Input button*/\n" +
            "    DDRD &= ~(1 << DDD2);         // Clear the PD2 pin\n" +
            "    // PD2 (PCINT0 pin) is now an input\n" +
            "    PORTD |= ~(1 << PORTD2);        // turn Off the Pull-up\n" +
            "\n" +
            "    PCICR |= (1 << PCIE0);     // set PCIE0 to enable PCMSK0 scan\n" +
            "    PCMSK0 |= (1 << PCINT0);   // set PCINT0 to trigger an interrupt on state change\n" +
            "\n" +
            "    sei();                     // turn on interrupts\n" +
            "\n" +
            "    DDRB |= _BV(DDB5);\n" +
            "    while(1)\n" +
            "    {\n" +
            "        /*main program loop here */PORTB &= ~_BV(PORTB5);\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "ISR (PCINT0_vect)\n" +
            "{\n" +
            "\tPORTB |= _BV(PORTB5);\n" +
            "    \t_delay_ms(1000);\n" +
            "\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n";

    public Tab_code() {
        // Required empty public constructor
    }
 /*
    public String readFromFile(){
        String code="";
        Resources res = getResources();
        InputStream in_s = res.openRawResource(R.raw.exp4_interrupt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in_s));
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            code +=line;
        }
        Log.d(TAG, "readFromFile: "+code);
        return code;
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View page3 =  inflater.inflate(R.layout.page3, container, false);
        mCodeView = (CodeView)page3.findViewById(R.id.codeView);

        mCodeView.setOnHighlightListener(this)
                .setOnHighlightListener(this)
                .setTheme(Theme.ATELIER_CAVE_DARK)
                .setCode(a)
                .setLanguage(Language.CPP)
                .setWrapLine(true)
                .setFontSize(14)
               .setZoomEnabled(true)
                .setShowLineNumber(true)
                .setStartLineNumber(0)
                .apply();
        return page3;
    }

    @Override
    public void onStartCodeHighlight() {

    }

    @Override
    public void onFinishCodeHighlight() {

    }

    @Override
    public void onLanguageDetected(Language language, int i) {

    }

    @Override
    public void onFontSizeChanged(int i) {

    }

    @Override
    public void onLineClicked(int i, String s) {

    }
}
