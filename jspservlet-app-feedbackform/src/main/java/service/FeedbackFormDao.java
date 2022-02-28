package service;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction; 

import model.FeedbackForm;
import utility.ConnectionManager;


public class  FeedbackFormDao{
	
	//Save Feedback Details
	public void saveFeedback(FeedbackForm feedback) {
		Transaction transaction = null;
		try (Session session = ConnectionManager.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the feedback object
			session.save(feedback);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Update Feedback Details
	 
	public void updateFeedback(FeedbackForm feedback ) {
		Transaction transaction = null;
		try (Session session = ConnectionManager.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the feedback object
			session.update(feedback);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Delete Feedback Details
	public void deleteFeedback(int formId) {

		Transaction transaction = null;
		try (Session session = ConnectionManager.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a feedback object
			FeedbackForm feedback = session.get(FeedbackForm.class, formId);
			if (feedback != null) {
				session.delete(feedback);
				System.out.println("feedback is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Display  Specific Feedback Details
	public FeedbackForm getFeedback(int formId) {

		Transaction transaction = null;
		FeedbackForm feedback = null;
		try (Session session = ConnectionManager.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get a feedback object
			feedback = session.get(FeedbackForm.class, formId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return feedback;
	}
	
	//Display  ALL Feedback Details
	@SuppressWarnings("unchecked")
	public List<FeedbackForm> getAllFeedback() {

		Transaction transaction = null;
		List<FeedbackForm> listOfFeedback = null;
		try (Session session = ConnectionManager.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get a feedback object
			
			listOfFeedback = session.createQuery("from FeedbackForm").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfFeedback;
	}
}

