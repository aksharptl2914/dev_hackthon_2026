# Vaccine Tracker – Smart Vaccine Eligibility & Reminder System
**DevHacks 2026**

A simple Java-based MVP that helps clinics and patients track vaccine eligibility, overdue boosters, and upcoming immunizations. Built as a beginner-friendly hackathon prototype.

---
### Eligibility Rules:
*Age-based:* If patients current age if less than the lower limit of the Age range for a particular vaccine only then, they are eligible to take that vaccine.
*Risk Factors:* For patients with immunocompromised diseases or pregnancy, the eligibility for the vaccine will be compromised.
## Problem

Patients often:
- Don’t know which vaccines they are eligible for
- Forget booster schedules
- Miss age-based or risk-based immunizations
- Lose track of vaccination history

Clinics struggle with:
- Manual eligibility checks
- Tracking booster timelines
- Reaching patients at the right time
- Preventing missed immunizations

---

## Solution

Vaccine Tracker is a lightweight prototype that:

- Determines vaccine eligibility based on:
    - Age (DOB)
    - Vaccination history (last dose date)
    - Booster schedules
    - Risk factors (pregnant, immunocompromised)
- Identifies:
    - Eligible now
    - Due soon
    - Overdue
    - Up-to-date
- Displays a patient-friendly immunization timeline
- Simulates reminders (Email, SMS, In-app)

This project focuses on clarity and correctness rather than production-scale architecture.

---

## Features

- Patient profile input (mock data in `Main.java`)
- Rule-based vaccine eligibility engine
- Booster and overdue detection
- Timeline visualization (console output)
- Reminder simulation (console output)
- Multiple patients supported
- Three example vaccines:
    - Flu Shot
    - Tetanus
    - COVID Booster

---

## Tech Stack

- Java 17
- Maven
- IntelliJ IDEA

## How to Run

- Clone the repository: git clone https://github.com/aksharptl2914/dev_hackthon_2026.git
- Open the project in IntelliJ IDEA.
- Run Main.java

## Team
- Akshar Patel
- Vrujal Patel
- Muhammad Faisal
- Wusimanjiang zulipikaer

This project was built collaboratively, with all team members contributing to the backend. As this was our first hackathon, we focused on learning quickly, iterating together, and build a potential prototype.