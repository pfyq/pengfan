package com.pf.unit.forkJoinPoolDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * RecursiveTask 是一种会返回结果的任务。它可以将自己的工作分割为若干更小任务，并将这些子任务的执行结果合并到一个集体结果。
 * MyRecursiveTask 类 继 承 自 RecursiveTask<Long>，这也就意味着它将返回一个 Long 类型的结果。
 * @author: JC.Lin
 * @data: 2019/2/21 23:27
 */
public class MyRecursiveTask extends RecursiveTask<Long> {

    private long workLoad = 0;
    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    /**
     * MyRecursiveTask 示例也会将工作分割为子任务，并通过 fork() 方法对这些子任务计划执行。此外，本示例还
     * 通过调用每个子任务的 join() 方法收集它们返回的结果。子任务的结果随后被合并到一个更大的结果，并最终将其返
     * 回。对于不同级别的递归，这种子任务的结果合并可能会发生递归。
     */
    @Override
    protected Long compute() {
        //如果工作超过阈值，就把任务分解成更小的任务
        if(this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);
            List<MyRecursiveTask> subtasks = new ArrayList<MyRecursiveTask>();
            subtasks.addAll(createSubtasks());
            for(MyRecursiveTask subtask : subtasks){
                subtask.fork();//子任务计划执行
            }
            long result = 0;
            for(MyRecursiveTask subtask : subtasks) {
                result += subtask.join();//收集它们返回的结果
            }
            return result;
        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }

    private List<MyRecursiveTask> createSubtasks() {
        List<MyRecursiveTask> subtasks = new ArrayList<MyRecursiveTask>();
        MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
        MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);
        subtasks.add(subtask1);
        subtasks.add(subtask2);
        return subtasks;
    }

    public static void main(String[] args) {
        //创建了一个并行级别为 4 的 ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        //创建一个有返回值的任务
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
        //线程池执行并返回结果
        long mergedResult = forkJoinPool.invoke(myRecursiveTask);//调用来获取最终执行结果
        System.out.println("mergedResult = " + mergedResult);
    }
}
