package com.projetodoertheia.a5cta.Contatos.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.projetodoertheia.a5cta.R;

public class Detail_Activity extends AppCompatActivity {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";
    private static final String EXTRA_Telefone = "EXTRA_TELEFONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);

        ((TextView)findViewById(R.id.quote_Texto)).setText(extras.getString(EXTRA_QUOTE));

        ((TextView)findViewById(R.id.quote_subtexto)).setText(extras.getString(EXTRA_ATTR));

        ((TextView)findViewById(R.id.quote_telefone)).setText(extras.getString(EXTRA_Telefone));




    }
}
