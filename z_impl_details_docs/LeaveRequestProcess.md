Hier ist ein Entwurf für die Datei `LeaveRequestProcess.md`, in der der gesamte Prozess und die bisherigen Fortschritte dokumentiert werden können:

---

# **Leave Request Process Documentation**

## **Overview**
The Leave Request Process is a business workflow implemented using Camunda BPMN 2.0 and Java Delegates. It manages the process of requesting, validating, approving, and updating leave requests within an organization.

---

## **Key Features**
1. **Request Leave:** Employees can request leave specifying the type and duration.
2. **Validate Leave Balance:** Checks if the requested leave days are within the remaining vacation balance.
3. **Approve/Reject Leave:** Based on the validation, the leave is either approved or rejected.
4. **Update Leave Record:** If approved, the remaining leave days are updated and the status is changed.

---

## **BPMN Model**
The BPMN diagram contains the following key elements:
1. **Start Event** - Initiates the process with input variables:
    - `leaveType`: Type of leave (e.g., vacation, sick leave).
    - `requestedVacationDays`: Number of days requested.
    - `remainingVacationDays`: Employee's available leave balance.
2. **Validation Task** (Service Task): Validates the requested days using `ValidateVacationDaysDelegate`.
3. **Approval Task** (User Task): Decision point where leave is approved or rejected.
4. **Update Leave Task** (Service Task): Updates the leave balance and status using `UpdateLeaveDelegate`.
5. **End Event** - Completes the process.

---

## **Implemented Java Delegates**

### **1. ValidateVacationDaysDelegate**
- **Purpose:** Validate that the requested leave days do not exceed the remaining vacation balance.
- **Inputs:**
    - `requestedVacationDays`
    - `remainingVacationDays`
- **Outputs:**
    - Throws a `BpmnError` if validation fails.
- **Logging Example:**
  ```
  Process details: activityName='Validate Balance', 
  activityId='Activity_1b5l5jl', 
  requestedVacationDays=5, remainingVacationDays=20
  ```

---

### **2. UpdateLeaveDelegate**
- **Purpose:** Updates the remaining leave balance and status after approval.
- **Inputs:**
    - `approve`: Boolean indicating if the leave is approved.
    - `requestedVacationDays`
    - `remainingVacationDays`
- **Outputs:**
    - Updates `remainingVacationDays` by subtracting `requestedVacationDays`.
    - Sets `leaveStatus` to `"Updated"`.

- **Logging Example:**
  ```
  Update Leave Process details: activityName='Update Leave', 
  remainingVacationDays=15, leaveStatus='Updated'
  ```

---

## **Process Variables**

| Variable               | Type     | Description                                  |
|------------------------|----------|----------------------------------------------|
| `leaveType`            | `String` | Type of leave (e.g., vacation, sick leave).  |
| `requestedVacationDays`| `Long`   | Number of days the employee is requesting.   |
| `remainingVacationDays`| `Long`   | Employee's available leave balance.          |
| `leaveStatus`          | `String` | Status of the leave request (e.g., pending, approved). |
| `approve`              | `Boolean`| Decision on whether the leave is approved.   |

---

## **Process Flow**

1. **Start Process:**
    - Define variables: `leaveType`, `requestedVacationDays`, `remainingVacationDays`, and `leaveStatus`.
2. **Validation:**
    - Validate leave using `ValidateVacationDaysDelegate`.
    - If invalid, throw a `BpmnError` and terminate the process.
3. **Approval:**
    - Manual approval by a manager.
    - Sets `approve` variable to `true` or `false`.
4. **Update Leave:**
    - If approved:
        - Update `remainingVacationDays` by subtracting `requestedVacationDays`.
        - Change `leaveStatus` to `"Updated"`.
    - If rejected:
        - Terminate the process without changes.

---

## **Testing**

### **Unit Tests**
- **ValidateVacationDaysDelegateTest:** Validates scenarios for requested days within and exceeding balance.
- **UpdateLeaveDelegateTest:** Ensures correct updates to variables based on approval status.

### **Integration Tests**
- Full process test to verify the workflow in Camunda.

---

## **Next Steps**
1. Refactor hardcoded variables in the Start Event into process inputs for better flexibility.
2. Add exception handling for boundary cases.
3. Create more comprehensive test cases for edge scenarios.

---

## **Repository**
The full implementation is available in the GitHub repository: [Leave Request Process](https://github.com/AhmedElyacoubiForJ/InvoiceAutomation/tree/main/src/main/java/edu/yacoubi/InvoiceAutomation/service/delegate).

---

## **Changelog**
- **2024-11-23:** Initial implementation completed with `ValidateVacationDaysDelegate` and `UpdateLeaveDelegate`.