package comr.example.mana.rytalo.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import comr.example.mana.rytalo.Adapters.PagerAdapter;
import comr.example.mana.rytalo.Helpers.CommonMethods;
import comr.example.mana.rytalo.Models.ImagesTable;
import comr.example.mana.rytalo.Models.Table_Datamodel;
import comr.example.mana.rytalo.Models.Tags_Table;
import comr.example.mana.rytalo.R;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout activity_drawer;
    private NavigationView nav_view;
    private ActionBarDrawerToggle aToggle;
    private Toolbar app_bar;
    private TabLayout tabs;
    private ViewPager pager;
    private TextView head_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Toolbar - Tablayout //
        app_bar=findViewById(R.id.activity_bar);
        setSupportActionBar(app_bar);
        activity_drawer = findViewById(R.id.activity_drawer);
        aToggle = new ActionBarDrawerToggle(this,activity_drawer,0,0);
        aToggle.syncState();
        nav_view=findViewById(R.id.main_navigation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*************************************************************************/

        /* Tab layout and pager settings */
        tabs=findViewById(R.id.main_tabs);
        pager = findViewById(R.id.tabs_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
        head_txt=app_bar.findViewById(R.id.app_headline);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.chats)
                {
                    head_txt.setText("Chats");
                    activity_drawer.closeDrawers();
                }
                else if (item.getItemId()==R.id.jobs)
                {
                    head_txt.setText("My Jobs");
                    activity_drawer.closeDrawers();


                }
                else if (item.getItemId()==R.id.history)
                {
                    head_txt.setText("History");
                    activity_drawer.closeDrawers();


                }
                else if(item.getItemId()==R.id.search)
                {
                    head_txt.setText("Search");
                    activity_drawer.closeDrawers();

                }
                else if (item.getItemId()==R.id.settings)
                {
                    head_txt.setText("Settings");
                    activity_drawer.closeDrawers();

                }
                return false;
            }
        });





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (aToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        boolean b;
        /* when press back .. close drawers ! */
        b= activity_drawer.isDrawerOpen(nav_view);
        if (b)
        {
            activity_drawer.closeDrawers();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CommonMethods.DeleteAllData(CommonMethods.RealmInit(getApplicationContext()),ImagesTable.class,getApplicationContext());
        CommonMethods.DeleteAllData(CommonMethods.RealmInit(getApplicationContext()),Table_Datamodel.class,getApplicationContext());
        CommonMethods.DeleteAllData(CommonMethods.RealmInit(getApplicationContext()),Tags_Table.class,getApplicationContext());
    }
}
