package Choice;

import Farm.Flower;
import Farm.Vegetable;
import Mgr.FarmMgr;
import Player.MoneyPresenter;

import java.util.ArrayList;
import java.util.List;

public class GainCrops extends ChoiceConsumeEnergy{
    public GainCrops()
    {
        description = "收获所有已经成熟的作物";
        needEnergy = 3;
    }

    public void Choose() throws InterruptedException
    {
        FarmMgr f = FarmMgr.GetInstance();
        int flowerNum=0;
        int vegetableNum=0;
        List<Flower> flowerList = new ArrayList<>();
        List<Vegetable> vegetableList = new ArrayList<>();
        //计算可以收获卖钱的花朵，然后把它们换钱并且从farmMgr里删了
        for(int i =0;i<f.flowers.size();i++)
        {
            Flower flower = f.flowers.get(i);
            if(flower.isMature())
            {
                flowerNum++;
                flowerList.add(flower);
            }
        }
        if(flowerNum>0)
        {
            for(int i =0;i<flowerList.size();i++)
            {
                f.flowers.remove(flowerList.get(i));
            }
            MoneyPresenter.GetInstance().EarnMoney(flowerNum*5);
        }
        //计算可以收获卖钱的蔬菜，然后把他们从FarmMgr里删了
        for(int i =0;i<f.vegetables.size();i++)
        {
            Vegetable vegetable = f.vegetables.get(i);
            if(vegetable.isMature())
            {
                vegetableNum++;
                vegetableList.add(vegetable);
            }
        }
        if(vegetableNum>0)
        {
            for(int i =0;i<vegetableList.size();i++)
            {
                f.vegetables.remove(vegetableList.get(i));
            }
            MoneyPresenter.GetInstance().EarnMoney(vegetableNum*10);
        }
    }
}
