import os,sys

def save_step_record(file_path):
    with open(file_path, 'a') as f:
        for steps in step_record_list:
            f.write(str(steps)+"\t")


base_dir = os.path.dirname(os.path.abspath(__file__))

write_to = base_dir+"/process_record.txt"
if os.path.exists(write_to):
    os.remove(write_to)

step_record_list=[2,3,4]
total_steps = 4
terminal = True

if terminal == True:
    step_record_list.append(total_steps)
    save_step_record(write_to)
    total_steps = 0
    step_record_list = []
else:
    total_steps+=1





