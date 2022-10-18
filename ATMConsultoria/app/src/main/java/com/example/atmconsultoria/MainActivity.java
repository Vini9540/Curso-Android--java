package com.example.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarEmail();

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_Principal, R.id.nav_servico, R.id.nav_clientes, R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        String celular = "tel:11996352894";
        String imagem = "https://www.google.com/search?q=praia+do+cedro&rlz=1C1GCEU_pt-BRBR1022BR1022&sxsrf=ALiCzsZ2tea2eQvmjYIv_iV63eSQSOKpPw:1664989911041&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjJ2c7hysn6AhVGOrkGHSjEBE4Q_AUoAXoECAIQAw&biw=1920&bih=937&dpr=1#imgrc=reAe44OGXDJttM";
        String endereco = "https://www.google.com.br/maps/place/Praia+do+Tenorio/@-23.4455207,-45.0987913,14.5z/data=!4m5!3m4!1s0x94cd53eca9cd6091:0x23061fbb55537aff!8m2!3d-23.4648663!4d-45.0573001?hl=pt-BR";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular) );
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem) );
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco) );

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "atendimento@atmconsultoria.com.br");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automatica");
        intent.setType("message/rfc822");


        startActivity(Intent.createChooser(intent,"Escolha um App de e-mail"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}