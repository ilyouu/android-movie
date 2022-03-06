package com.example.movieproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.movieproject.adapter.BannerMoviesPagerAdapter;
import com.example.movieproject.adapter.MainRecyclerViewAdapter;
import com.example.movieproject.model.AllCategory;
import com.example.movieproject.model.BannerMovies;
import com.example.movieproject.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout tabIndicator, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> moviesBannerList;
    List<BannerMovies> animeBannerList;

    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;

    MainRecyclerViewAdapter mainRecyclerViewAdapter;
    RecyclerView mainRecylerView;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabIndicator = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScrollView = findViewById(R.id.nestes_scroll);
        appBarLayout = findViewById(R.id.appbar);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1, "sp", "https://popcornreviewss.com/wp-content/uploads/2021/12/Spider-Man-No-Way-Home-SPOILER-REVIEW.jpg", ""));
        homeBannerList.add(new BannerMovies(2, "dr", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));
        homeBannerList.add(new BannerMovies(3, "eg", "https://silverscreeninsider.com/content/news/ic_1554842305_834x367_true.jpg", ""));

        moviesBannerList = new ArrayList<>();
        moviesBannerList.add(new BannerMovies(1, "Loki", "https://kienthucmoi.net/img/2021/06/23/review-loki-sieu-pham-moi-gay-bao-man-anh-cu-2.jpg", ""));
        moviesBannerList.add(new BannerMovies(2, "WandaVision", "https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/2604045F76DEAB54D0499A8CC9FDC17F374BD3CFCBDBCCC14A70B9A44A6512CF/scale?width=1200&aspectRatio=1.78&format=jpeg", ""));
        moviesBannerList.add(new BannerMovies(3, "Test", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));

        animeBannerList = new ArrayList<>();
        animeBannerList.add(new BannerMovies(1, "Test", "https://lh3.googleusercontent.com/pIcG7aNxaKhN6FQtMldPXYi3Dy7uMcPRNTJrOyvOejKtTNTofqaubaObTme3Ok3ZFEIgJyLimZRaH7zWFuYXUQ6dbBrJG8fD0Cl_8VL1ziIH4QPFlC72-G_VYVjKomdRNNaLu273LUl9_JBUcARPbwuj5TZ7cMKr6RLWm0tUN3ajvCC8Mh9DjWFeBzR-244AlV0emCbPgVInBodvS9uluRG_OPWzQQsmvlHLwyPNf2Zuk3lPrjPetlz4MpvjhXDDYQvDKFC2_pqK8_kMdFEfUT5VD-CPKswxNa4cVaWBRahBMZvXLauk1r3t5GKqWgxKBjPes2hPHxnESDT6ODIhofYrM1roi6dlp1vzSROtY6YoRrcqM5Ci-VC0rvy4F0CHyiwTrsAacWGPIbFaW9kaU4UBhYWPTsXgwQEIJCNcXDS9vjblPPjQeyf5Q9R6SZ9G2fwxEX73sc94q0VrdGRqxUu_bmagr_tDQubRp3dLI68gPxrPDkuiqY_bu2veoF1AbYRQOzIlgY8TiZzzdSSu8P6y9mmpZein-QYpOn8VoMkZUJZr3Hak5FCfWVFkCBU1tdSULmjjELiiDoFANQNB195Ni4c4Vdp1iKdYL5EMzoUZCQOHhvdq2Upafl0iDU1i04tL2N8C9WuyUxG-J8mqu2APlUrQxgasS6Hj-2fHc-NcwA7lW18Y8oF9_aBLzPo5YHrI5w8OKI53yjlpQu3snyY=w1137-h635-no?authuser=0", ""));
        animeBannerList.add(new BannerMovies(2, "Test", "https://lh3.googleusercontent.com/4lJXUw0xBcQYw40Hb2q-4YKK2_315ljoQsLxJEPUPnJoPu-O2QXpXoHeSYpImBWQJjW-kUqC59fCVcqU4U9FPP4lj7nM8Ffe3iMrLBUtS6Z-66n3rUkQrsDZCjGbfbHt4j1R-i567ptQFejtzY7jKm9GyxKCkuswB5iO56y3mSD3H15u7ltiTeJ24FxMzEw54tifvBZ4s5Fiy5CT9HKOVxsx8RsKrwasG0bTv7p8XkiXvSVS2MAPebyhclDoD09kC7ngLUgtxlfa8BsfdvT-HaqeKSLpcLhemxtx2I2ROcFuobrj3fY3EBoT4AgHEvce9UCGCTy25GaJ9HvET38STm9IbQqzCq25eMLHVAbOtR0IT5Cn2kiNx7IRKdPyD0WOlYflP1psIi8ooiy-FngBm-aupeDdn2qoVqtyXEUNOvfhFPbeSUFKAfCqvaHUZE5enwLuihyZDNSvCY-t0YdrgfjWVCuf5xWGzvLdCa6W1AC5YE4ghSXTegqNdq0jyZ2TsEfKnFkH9dTV96QrT1pHV7FwgA_2NECb5mBAy3L50lFvlRPz7r7tReWoEN-I1yqdVOS_zu5IC9DhaoiSQzzRM1GDLarJ25tCav91RSgDrdW658DHbodvac7YpaMPrOm0sa1dCf--ugl5zQKUXtrNIhmmV1mTYy1cs8UabEAntTtGZ_YTkvqPRe95C4XXdOBc0WToRgWo0FPd12SWpSOQxqk=w1285-h635-no?authuser=0", ""));
        animeBannerList.add(new BannerMovies(3, "Test", "https://lh3.googleusercontent.com/V_ZQN8Zg2plH1eUBBMSVgJqJfai6j_gOFomtJ8SKgIO5gVXoxxbJ46M3KVMcNHkVpq3uRR_4rNTriyrfhqecTfgoyrGElwN1qHNGTp4qQsX68SU9DmlZwjxnFQTYR-4Mjf5pGystIjcGkSb7UTmTk5-xPDC1RxfPWe1F7g0RDfdCs_OeuLJYdeBnavTDckc-2bawJRcOIVjbdnk3RixtxVsv8Uvaczm2_wpbJZDFBKGlrcpJIgadPrXT5WkOf200LGVg5-c4sNHVRbQyQiZzDmF9cd-W8joyJmITNP0zsg-2Xb3PBJGRayzF6bNeiI94nHmxMlOBFPdfGJRVLmgi-1JS4JV4mseYDrEOLyyEN02ehj2EkHwGj5XRNtTQgas-lybftAjTi7IiTikcVmU5_LCXjX50cDP09p821lpVL0iPFWeiypD7VAgEwCvusj0BxRJY1-FQ5sVyy3OfPIinGQc3uQVdyWaWTTQSHZe21J_g1EN4VvyfQegDQGADlUUrCf1i309yoK62a7ZQLwOaV2KhDoqJA6Rql0To3yBxB2EJIcC92a_bwg32lC4sOclEzked6DY8ARaMFwBBjJSx6uxpF17LHa623OZuEvElEaeYYExxP64ykLSiPpoLLQrDhzwNIgSg7N13U8DdbmbwrlumZJWBLQw36-qNOXIV31-JHcsn5IKjyX5PiTtPeVjQMUM310_SvPnxTeMk1UCxUls=w1105-h635-no?authuser=0", ""));


        setBannerMoviesPagerAdapter(homeBannerList);

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(moviesBannerList);
                        break;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(animeBannerList);
                        break;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        List<CategoryItem> homeCategoryItemList1 = new ArrayList<>();
        homeCategoryItemList1.add(new CategoryItem(1, "Test 1", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));
        homeCategoryItemList1.add(new CategoryItem(2, "Test 2", "https://popcornreviewss.com/wp-content/uploads/2021/12/Spider-Man-No-Way-Home-SPOILER-REVIEW.jpg", ""));
        homeCategoryItemList1.add(new CategoryItem(3, "Test 3", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));
        homeCategoryItemList1.add(new CategoryItem(4, "Test 4", "https://popcornreviewss.com/wp-content/uploads/2021/12/Spider-Man-No-Way-Home-SPOILER-REVIEW.jpg", ""));
        homeCategoryItemList1.add(new CategoryItem(5, "Test 5", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));

        List<CategoryItem> homeCategoryItemList2 = new ArrayList<>();
        homeCategoryItemList2.add(new CategoryItem(1, "Test 1", "https://kienthucmoi.net/img/2021/06/23/review-loki-sieu-pham-moi-gay-bao-man-anh-cu-2.jpg", ""));
        homeCategoryItemList2.add(new CategoryItem(2, "Test 2", "https://popcornreviewss.com/wp-content/uploads/2021/12/Spider-Man-No-Way-Home-SPOILER-REVIEW.jpg", ""));
        homeCategoryItemList2.add(new CategoryItem(3, "Test 3", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));
        homeCategoryItemList2.add(new CategoryItem(4, "Test 4", "https://popcornreviewss.com/wp-content/uploads/2021/12/Spider-Man-No-Way-Home-SPOILER-REVIEW.jpg", ""));
        homeCategoryItemList2.add(new CategoryItem(5, "Test 5", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));

        List<CategoryItem> homeCategoryItemList3 = new ArrayList<>();
        homeCategoryItemList3.add(new CategoryItem(1, "Test 1", "https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/2604045F76DEAB54D0499A8CC9FDC17F374BD3CFCBDBCCC14A70B9A44A6512CF/scale?width=1200&aspectRatio=1.78&format=jpeg", ""));
        homeCategoryItemList3.add(new CategoryItem(2, "Test 2", "https://kienthucmoi.net/img/2021/06/23/review-loki-sieu-pham-moi-gay-bao-man-anh-cu-2.jpg", ""));
        homeCategoryItemList3.add(new CategoryItem(3, "Test 3", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));
        homeCategoryItemList3.add(new CategoryItem(4, "Test 4", "https://popcornreviewss.com/wp-content/uploads/2021/12/Spider-Man-No-Way-Home-SPOILER-REVIEW.jpg", ""));
        homeCategoryItemList3.add(new CategoryItem(5, "Test 5", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));

        List<CategoryItem> homeCategoryItemList4 = new ArrayList<>();
        homeCategoryItemList4.add(new CategoryItem(1, "Test 1", "https://lh3.googleusercontent.com/pIcG7aNxaKhN6FQtMldPXYi3Dy7uMcPRNTJrOyvOejKtTNTofqaubaObTme3Ok3ZFEIgJyLimZRaH7zWFuYXUQ6dbBrJG8fD0Cl_8VL1ziIH4QPFlC72-G_VYVjKomdRNNaLu273LUl9_JBUcARPbwuj5TZ7cMKr6RLWm0tUN3ajvCC8Mh9DjWFeBzR-244AlV0emCbPgVInBodvS9uluRG_OPWzQQsmvlHLwyPNf2Zuk3lPrjPetlz4MpvjhXDDYQvDKFC2_pqK8_kMdFEfUT5VD-CPKswxNa4cVaWBRahBMZvXLauk1r3t5GKqWgxKBjPes2hPHxnESDT6ODIhofYrM1roi6dlp1vzSROtY6YoRrcqM5Ci-VC0rvy4F0CHyiwTrsAacWGPIbFaW9kaU4UBhYWPTsXgwQEIJCNcXDS9vjblPPjQeyf5Q9R6SZ9G2fwxEX73sc94q0VrdGRqxUu_bmagr_tDQubRp3dLI68gPxrPDkuiqY_bu2veoF1AbYRQOzIlgY8TiZzzdSSu8P6y9mmpZein-QYpOn8VoMkZUJZr3Hak5FCfWVFkCBU1tdSULmjjELiiDoFANQNB195Ni4c4Vdp1iKdYL5EMzoUZCQOHhvdq2Upafl0iDU1i04tL2N8C9WuyUxG-J8mqu2APlUrQxgasS6Hj-2fHc-NcwA7lW18Y8oF9_aBLzPo5YHrI5w8OKI53yjlpQu3snyY=w1137-h635-no?authuser=0", ""));
        homeCategoryItemList4.add(new CategoryItem(2, "Test 2", "https://lh3.googleusercontent.com/4lJXUw0xBcQYw40Hb2q-4YKK2_315ljoQsLxJEPUPnJoPu-O2QXpXoHeSYpImBWQJjW-kUqC59fCVcqU4U9FPP4lj7nM8Ffe3iMrLBUtS6Z-66n3rUkQrsDZCjGbfbHt4j1R-i567ptQFejtzY7jKm9GyxKCkuswB5iO56y3mSD3H15u7ltiTeJ24FxMzEw54tifvBZ4s5Fiy5CT9HKOVxsx8RsKrwasG0bTv7p8XkiXvSVS2MAPebyhclDoD09kC7ngLUgtxlfa8BsfdvT-HaqeKSLpcLhemxtx2I2ROcFuobrj3fY3EBoT4AgHEvce9UCGCTy25GaJ9HvET38STm9IbQqzCq25eMLHVAbOtR0IT5Cn2kiNx7IRKdPyD0WOlYflP1psIi8ooiy-FngBm-aupeDdn2qoVqtyXEUNOvfhFPbeSUFKAfCqvaHUZE5enwLuihyZDNSvCY-t0YdrgfjWVCuf5xWGzvLdCa6W1AC5YE4ghSXTegqNdq0jyZ2TsEfKnFkH9dTV96QrT1pHV7FwgA_2NECb5mBAy3L50lFvlRPz7r7tReWoEN-I1yqdVOS_zu5IC9DhaoiSQzzRM1GDLarJ25tCav91RSgDrdW658DHbodvac7YpaMPrOm0sa1dCf--ugl5zQKUXtrNIhmmV1mTYy1cs8UabEAntTtGZ_YTkvqPRe95C4XXdOBc0WToRgWo0FPd12SWpSOQxqk=w1285-h635-no?authuser=0", ""));
        homeCategoryItemList4.add(new CategoryItem(3, "Test 3", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));
        homeCategoryItemList4.add(new CategoryItem(4, "Test 4", "https://popcornreviewss.com/wp-content/uploads/2021/12/Spider-Man-No-Way-Home-SPOILER-REVIEW.jpg", ""));
        homeCategoryItemList4.add(new CategoryItem(5, "Test 5", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));

        List<CategoryItem> homeCategoryItemList5 = new ArrayList<>();
        homeCategoryItemList5.add(new CategoryItem(1, "Test 1", "https://lh3.googleusercontent.com/pIcG7aNxaKhN6FQtMldPXYi3Dy7uMcPRNTJrOyvOejKtTNTofqaubaObTme3Ok3ZFEIgJyLimZRaH7zWFuYXUQ6dbBrJG8fD0Cl_8VL1ziIH4QPFlC72-G_VYVjKomdRNNaLu273LUl9_JBUcARPbwuj5TZ7cMKr6RLWm0tUN3ajvCC8Mh9DjWFeBzR-244AlV0emCbPgVInBodvS9uluRG_OPWzQQsmvlHLwyPNf2Zuk3lPrjPetlz4MpvjhXDDYQvDKFC2_pqK8_kMdFEfUT5VD-CPKswxNa4cVaWBRahBMZvXLauk1r3t5GKqWgxKBjPes2hPHxnESDT6ODIhofYrM1roi6dlp1vzSROtY6YoRrcqM5Ci-VC0rvy4F0CHyiwTrsAacWGPIbFaW9kaU4UBhYWPTsXgwQEIJCNcXDS9vjblPPjQeyf5Q9R6SZ9G2fwxEX73sc94q0VrdGRqxUu_bmagr_tDQubRp3dLI68gPxrPDkuiqY_bu2veoF1AbYRQOzIlgY8TiZzzdSSu8P6y9mmpZein-QYpOn8VoMkZUJZr3Hak5FCfWVFkCBU1tdSULmjjELiiDoFANQNB195Ni4c4Vdp1iKdYL5EMzoUZCQOHhvdq2Upafl0iDU1i04tL2N8C9WuyUxG-J8mqu2APlUrQxgasS6Hj-2fHc-NcwA7lW18Y8oF9_aBLzPo5YHrI5w8OKI53yjlpQu3snyY=w1137-h635-no?authuser=0", ""));
        homeCategoryItemList5.add(new CategoryItem(2, "Test 2", "https://lh3.googleusercontent.com/4lJXUw0xBcQYw40Hb2q-4YKK2_315ljoQsLxJEPUPnJoPu-O2QXpXoHeSYpImBWQJjW-kUqC59fCVcqU4U9FPP4lj7nM8Ffe3iMrLBUtS6Z-66n3rUkQrsDZCjGbfbHt4j1R-i567ptQFejtzY7jKm9GyxKCkuswB5iO56y3mSD3H15u7ltiTeJ24FxMzEw54tifvBZ4s5Fiy5CT9HKOVxsx8RsKrwasG0bTv7p8XkiXvSVS2MAPebyhclDoD09kC7ngLUgtxlfa8BsfdvT-HaqeKSLpcLhemxtx2I2ROcFuobrj3fY3EBoT4AgHEvce9UCGCTy25GaJ9HvET38STm9IbQqzCq25eMLHVAbOtR0IT5Cn2kiNx7IRKdPyD0WOlYflP1psIi8ooiy-FngBm-aupeDdn2qoVqtyXEUNOvfhFPbeSUFKAfCqvaHUZE5enwLuihyZDNSvCY-t0YdrgfjWVCuf5xWGzvLdCa6W1AC5YE4ghSXTegqNdq0jyZ2TsEfKnFkH9dTV96QrT1pHV7FwgA_2NECb5mBAy3L50lFvlRPz7r7tReWoEN-I1yqdVOS_zu5IC9DhaoiSQzzRM1GDLarJ25tCav91RSgDrdW658DHbodvac7YpaMPrOm0sa1dCf--ugl5zQKUXtrNIhmmV1mTYy1cs8UabEAntTtGZ_YTkvqPRe95C4XXdOBc0WToRgWo0FPd12SWpSOQxqk=w1285-h635-no?authuser=0", ""));
        homeCategoryItemList5.add(new CategoryItem(3, "Test 3", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));
        homeCategoryItemList5.add(new CategoryItem(4, "Test 4", "https://popcornreviewss.com/wp-content/uploads/2021/12/Spider-Man-No-Way-Home-SPOILER-REVIEW.jpg", ""));
        homeCategoryItemList5.add(new CategoryItem(5, "Test 5", "https://images.tv9hindi.com/wp-content/uploads/2022/02/Doctor-Strange.jpg", ""));


        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1, "PHIM HOT", homeCategoryItemList1));
        allCategoryList.add(new AllCategory(2, "PHIM CHIẾU RẠP", homeCategoryItemList2));
        allCategoryList.add(new AllCategory(3, "PHIM BỘ MỚI CẬP NHẬT", homeCategoryItemList3));
        allCategoryList.add(new AllCategory(4, "PHIM HOẠT HÌNH", homeCategoryItemList4));
        allCategoryList.add(new AllCategory(5, "PHIM HOẠT HÌNH CHIẾU RẠP", homeCategoryItemList5));
        allCategoryList.add(new AllCategory(6, "PHIM HOẠT HÌNH CHIẾU RẠP", homeCategoryItemList5));
        allCategoryList.add(new AllCategory(7, "PHIM HOẠT HÌNH CHIẾU RẠP", homeCategoryItemList5));

        setMainRecylerView(allCategoryList);

    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);

        tabIndicator.setupWithViewPager(bannerMoviesViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 4000, 6000);
        tabIndicator.setupWithViewPager(bannerMoviesViewPager);
    }

    class AutoSlider extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size()-1){
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);

                    }else {
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public void setMainRecylerView(List<AllCategory> allCategoryList){

        mainRecylerView = findViewById(R.id.main_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecylerView.setLayoutManager(layoutManager);
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(this, allCategoryList);
        mainRecylerView.setAdapter(mainRecyclerViewAdapter);
    }

    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0, 0);
        appBarLayout.setExpanded(true);
    }

}