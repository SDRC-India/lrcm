package org.sdrc.lrcasemanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.sdrc.lrcasemanagement.R;
import org.sdrc.lrcasemanagement.activity.PatientActivity;
import org.sdrc.lrcasemanagement.model.PatientModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 26-01-2017.
 */

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.MyViewHolder> {

    private LayoutInflater layoutInflater;
    List<PatientModel> patientModel = Collections.emptyList();
    Context context;
    public PatientListAdapter(Context context, List<PatientModel> patientModel){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.patientModel = patientModel;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.custom_data_list_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        PatientModel patientModels = patientModel.get(position);
        holder.serialNo.setText("Sl No : "+String.valueOf (patientModels.getSerialNo() != null?patientModels.getSerialNo():""));
        holder.patientName.setText(patientModels.getPatientName());
        String firstLetterStr=patientModels.getPatientName().substring(0,1);
        holder.firstLetter.setText(firstLetterStr);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy h:mm a");
        holder.addmissionDate.setText(simpledateformat.format(patientModels.getAdmissionDateAndTime()));
        if (patientModels.getClosed() != null && patientModels.getClosed()) {
            holder.patientStatus.setText("Closed");
            holder.patientStatus.setTextColor(Color.parseColor("#545454"));
        }else {
            holder.patientStatus.setText("Open");
            holder.patientStatus.setTextColor(Color.parseColor("#0EB415"));
        }
        holder.patientList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context.getApplicationContext(), PatientActivity.class);
                intent.putExtra("patientModel", patientModel.get(position));
                intent.putExtra("fab_status","edit");
                context.startActivity(intent);
                //((PatientListActivity)context).finish();
            }
        });
    }


    @Override
    public int getItemCount() {
        return patientModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstLetter;
        TextView serialNo;
        TextView patientName;
        TextView addmissionDate;
        TextView patientStatus;
        LinearLayout patientList;

        public MyViewHolder(View itemView) {
            super(itemView);

            patientList = (LinearLayout) itemView.findViewById(R.id.patient_list);
            firstLetter = (TextView) itemView.findViewById(R.id.firstLetter);
            serialNo = (TextView) itemView.findViewById(R.id.serial_no);
            patientName = (TextView) itemView.findViewById(R.id.patient_name);
            patientStatus = (TextView) itemView.findViewById(R.id.patient_status);
            addmissionDate = (TextView) itemView.findViewById(R.id.admission_date);
        }
    }

    public void setFilter(List<PatientModel> patientModels) {
        patientModel = new ArrayList<>();
        patientModel.addAll(patientModels);
        notifyDataSetChanged();
    }


}
