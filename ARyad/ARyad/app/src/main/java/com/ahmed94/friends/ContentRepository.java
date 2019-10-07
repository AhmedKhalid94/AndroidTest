package com.ahmed94.friends;

import com.ahmed94.friends.Object.ImageItem;

import java.util.ArrayList;
import java.util.List;

public class ContentRepository {

    public static final int ALPHABETS = 1;
    public static final int ANIMALS = 2;
    public static final int Birds = 3;






    static int[] sounds;

    public static int[] getSoundsByType(int type) {
        switch (type) {
            case ALPHABETS:
                sounds = new int[]{R.raw.l22, R.raw.l23,
                        R.raw.l24, R.raw.l25, R.raw.l26, R.raw.l27, R.raw.l28, R.raw.l1, R.raw.l2, R.raw.l3, R.raw.l4, R.raw.l5, R.raw.l6, R.raw.l7, R.raw.l8,
                        R.raw.l9, R.raw.l10, R.raw.l11, R.raw.l12, R.raw.l13, R.raw.l14, R.raw.l15,
                        R.raw.l16, R.raw.l17, R.raw.l18, R.raw.l19, R.raw.l20, R.raw.l21};
                break;

            case ANIMALS:
                sounds = new int[]{R.raw.alligator, R.raw.bear, R.raw.elephant, R.raw.lion, R.raw.monkey, R.raw.rabbit,
                        R.raw.snake,  R.raw.tiger, R.raw.zebra, R.raw.camel, R.raw.cat, R.raw.cow,
                        R.raw.dog,  R.raw.faras, R.raw.fox_ar, R.raw.giraffe_ar, R.raw.horse_ar
                        , R.raw.ox_ar, R.raw.pig_ar, R.raw.turtle_ar,R.raw.waheed};
                break;

            case Birds:
                sounds = new int[]{R.raw.bee, R.raw.bird,R.raw.duck, R.raw.butterfly, R.raw.chicken,  R.raw.owl, R.raw.ostrich,R.raw.pigeon,R.raw.rooster};
                break;

        }
        return sounds;
    }

    public static List<ImageItem> getImagesByType(int type) {
        List<ImageItem> imageItemList = new ArrayList<>();
        switch (type) {
            case ALPHABETS:
                imageItemList.add(new ImageItem("", R.drawable.l22));
                imageItemList.add(new ImageItem("", R.drawable.l23));
                imageItemList.add(new ImageItem("", R.drawable.l24));
                imageItemList.add(new ImageItem("", R.drawable.l25));
                imageItemList.add(new ImageItem("", R.drawable.l26));
                imageItemList.add(new ImageItem("", R.drawable.l27));
                imageItemList.add(new ImageItem("", R.drawable.l28));
                imageItemList.add(new ImageItem("", R.drawable.l1));
                imageItemList.add(new ImageItem("", R.drawable.l2));
                imageItemList.add(new ImageItem("", R.drawable.l3));
                imageItemList.add(new ImageItem("", R.drawable.l4));
                imageItemList.add(new ImageItem("", R.drawable.l5));
                imageItemList.add(new ImageItem("", R.drawable.l6));
                imageItemList.add(new ImageItem("", R.drawable.l7));
                imageItemList.add(new ImageItem("", R.drawable.l8));
                imageItemList.add(new ImageItem("", R.drawable.l9));
                imageItemList.add(new ImageItem("", R.drawable.l10));
                imageItemList.add(new ImageItem("", R.drawable.l11));
                imageItemList.add(new ImageItem("", R.drawable.l12));
                imageItemList.add(new ImageItem("", R.drawable.l13));
                imageItemList.add(new ImageItem("", R.drawable.l14));
                imageItemList.add(new ImageItem("", R.drawable.l15));
                imageItemList.add(new ImageItem("", R.drawable.l16));
                imageItemList.add(new ImageItem("", R.drawable.l17));
                imageItemList.add(new ImageItem("", R.drawable.l18));
                imageItemList.add(new ImageItem("", R.drawable.l19));
                imageItemList.add(new ImageItem("", R.drawable.l20));
                imageItemList.add(new ImageItem("", R.drawable.l21));
                break;

            case ANIMALS:
                imageItemList.add(new ImageItem("تمساح", R.drawable.alligator));
                imageItemList.add(new ImageItem("دب ", R.drawable.bear));
                imageItemList.add(new ImageItem("فيل", R.drawable.elephant));
                imageItemList.add(new ImageItem("أسد", R.drawable.lion));
                imageItemList.add(new ImageItem("قرد", R.drawable.monkey));
                imageItemList.add(new ImageItem("أرنب", R.drawable.rabbit));
                imageItemList.add(new ImageItem("أفعى", R.drawable.snake));
                imageItemList.add(new ImageItem("نمر", R.drawable.tiger));
                imageItemList.add(new ImageItem("حمار الوحش", R.drawable.zebra));
                imageItemList.add(new ImageItem("جمل", R.drawable.camel));
                imageItemList.add(new ImageItem("قطة", R.drawable.cat ));
                imageItemList.add(new ImageItem("بقرة", R.drawable.cow ));
                imageItemList.add(new ImageItem("كلب", R.drawable.dog));
                imageItemList.add(new ImageItem("فرس النهر ", R.drawable.farasnaher));
                imageItemList.add(new ImageItem("ثعلب", R.drawable.fox));
                imageItemList.add(new ImageItem("زرافة", R.drawable.gerafi));
                imageItemList.add(new ImageItem("حصان", R.drawable.horse));
                imageItemList.add(new ImageItem("ثور", R.drawable.ox));
                imageItemList.add(new ImageItem("خنزير", R.drawable.pig));
                imageItemList.add(new ImageItem("سلحفاة", R.drawable.turtil));
                imageItemList.add(new ImageItem("وحيد القرن", R.drawable.waheed));

                break;

            case Birds:
                imageItemList.add(new ImageItem("نحلة", R.drawable.bee));
                imageItemList.add(new ImageItem("عصفور", R.drawable.bird));
                imageItemList.add(new ImageItem("بطة", R.drawable.duck));
                imageItemList.add(new ImageItem("فراشة", R.drawable.butterfly));
                imageItemList.add(new ImageItem("دجاجة", R.drawable.chicken));
                imageItemList.add(new ImageItem("بومة", R.drawable.owl));
                imageItemList.add(new ImageItem("نعامة", R.drawable.ostrich));
                imageItemList.add(new ImageItem("حمامة", R.drawable.pigeon));
                imageItemList.add(new ImageItem("ديك", R.drawable.rooster));
                break;




        }
        return imageItemList;
    }
}
