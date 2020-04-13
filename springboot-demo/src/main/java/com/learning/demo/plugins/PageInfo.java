package com.learning.demo.plugins;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageInfo<T> extends Page<T> {
    //前一页
    private int prePage;
    //下一页
    private int nextPage;

    //导航页码数
    private int navigatePages = 8;
    //所有导航页号
    private int[] navigatepageNums;
    //导航条上的第一页
    private int navigateFirstPage;
    //导航条上的最后一页
    private int navigateLastPage;

    /**
     * 计算导航页
     */
    private void calcNavigatepageNums() {
        int pages = (int) super.getPages() + 1;
        int pageNum = (int) super.getCurrent();
        System.out.println("pages：" + pages + ", pageNum" + pageNum);
        //当总页数小于或等于导航页码数时
        if (pages <= this.navigatePages) {
            this.navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                this.navigatepageNums[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            this.navigatepageNums = new int[this.navigatePages];
            int startNum = pageNum - this.navigatePages / 2;
            int endNum = pageNum + this.navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < this.navigatePages; i++) {
                    this.navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //最后navigatePages页
                for (int i = this.navigatePages - 1; i >= 0; i--) {
                    this.navigatepageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < this.navigatePages; i++) {
                    this.navigatepageNums[i] = startNum++;
                }
            }
        }
    }

    /**
     * 计算前后页，第一页，最后一页
     */
    private void calcPage() {
        int pages = (int) super.getPages() + 1;
        int pageNum = (int) super.getCurrent();

        if (navigatepageNums != null && navigatepageNums.length > 0) {
            navigateFirstPage = navigatepageNums[0];
            navigateLastPage = navigatepageNums[navigatepageNums.length - 1];
            if (pageNum > 1) {
                prePage = pageNum - 1;
            }
            if (pageNum < pages) {
                nextPage = pageNum + 1;
            }
        }
    }

    public int[] getNavigatepageNums() {
        this.calcNavigatepageNums();
        return navigatepageNums;
    }

    public int getNavigateFirstPage() {
        this.calcPage();
        return navigateFirstPage;
    }

    public int getNavigateLastPage() {
        this.calcPage();
        return navigateLastPage;
    }
}
